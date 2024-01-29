package com.exam.controller;

import com.exam.aiWork.ChatRequest;
import com.exam.aiWork.ChatResponse;
import com.exam.model.exams.LearningPlan;
import com.exam.services.LearningPlanService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/openAi")
public class ChatAiController {

    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @Autowired
    private LearningPlanService learningPlanService;

    @PostMapping("/createPlan/{userId}")
    public ResponseEntity<String> createEducationPlan(@RequestParam String prompt, @PathVariable Long userId) {
        // Create a request
        ChatRequest request = new ChatRequest(model, prompt);
System.out.println("in createeducation plan");
        // Call the API

        ChatResponse response = restTemplate.postForObject(apiUrl, request, ChatResponse.class);
        
        response.getChoices().stream().forEach(choice -> System.out.println(choice.getMessage().getRole()+choice.getMessage().getContent()));

        System.out.println(response.toString());
        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return new ResponseEntity<String>("response not found - from controller chatAi",HttpStatus.NOT_FOUND);
        }

        // Save AI response in the database
        learningPlanService.saveOpenAiResponse(response, userId);
       
        // Return the first response
        return new ResponseEntity<String>(response.getChoices().get(0).getMessage().getContent(),HttpStatus.CREATED);
    }
    
    @GetMapping("/getPlan/{userId}")
    public ResponseEntity<List<LearningPlan>> getEducationPlanOfUser(@PathVariable Long userId)
    {
    	return new ResponseEntity<List<LearningPlan>>(learningPlanService.getAllLearningPlansByUser(userId),HttpStatus.OK) ;   	
    }
}


