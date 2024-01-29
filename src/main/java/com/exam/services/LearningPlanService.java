package com.exam.services;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.aiWork.ChatResponse;
import com.exam.model.User;
import com.exam.model.exams.LearningItem;
import com.exam.model.exams.LearningPlan;
import com.exam.repo.LearningItemRepository;
import com.exam.repo.LearningPlanRepository;
import com.exam.repo.userRepository;

@Service
public class LearningPlanService {

    @Autowired
    private LearningPlanRepository learningPlanRepository;

    @Autowired
    private LearningItemRepository learningItemRepository;
    
    @Autowired
    private userRepository uesRepository;

    public void saveOpenAiResponse(ChatResponse chatResponse, Long userId) {

    	
        User user = uesRepository.findById(userId).orElse(null);

        if (user != null) {

        	LearningPlan learningPlan = new LearningPlan();
            learningPlan.setUser(user);
            learningPlan.setStartDate(new Date());
            learningPlan.setEndDate(new Date());

            learningPlanRepository.save(learningPlan);

            List<String> openAiResponses = chatResponse.getChoices().stream()
                    .map(choice -> choice.getMessage().getContent())
                    .toList();

            for (int i = 0; i < openAiResponses.size(); i++) {
                LearningItem learningItem = new LearningItem();
                learningItem.setTitle("Response " + (i + 1));
                learningItem.setDescription(openAiResponses.get(i));
                learningItem.setLearningPlan(learningPlan);
                learningItem.setOrderInPlan(i + 1);

                learningItemRepository.save(learningItem);
            }
        }
    }
    
    public List<LearningPlan> getAllLearningPlansByUser(Long userId) {
        return learningPlanRepository.getAllLearningPlansByUser_Id(userId);
    }
    
    
}
