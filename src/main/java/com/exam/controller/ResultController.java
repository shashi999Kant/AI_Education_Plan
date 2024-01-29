package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.User;
import com.exam.model.exams.Quiz;
import com.exam.model.exams.Result;
import com.exam.services.QuizService;
import com.exam.services.ResultService;
import com.exam.services.UserService;

@RestController
@RequestMapping("/api/result")
public class ResultController {
	
	@Autowired
	private ResultService resultservice;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/user/{userId}/quiz/{quizId}")
	public ResponseEntity<?> addResult(@RequestBody Result result
			,@PathVariable Long userId ,@PathVariable Long quizId)
	{
		User userById = userService.getUserById(userId);
		Quiz quizById = quizService.getQuiz(quizId);
		result.setUser(userById);
		result.setQuiz(quizById);
		return ResponseEntity.ok(this.resultservice.addResult(result));
	}
	
	@GetMapping("/{qid}/{uid}")
	public ResponseEntity<?> getResultByUserAndQuiz(@PathVariable("qid") long qid,@PathVariable("uid") long uid)
	{
		Quiz quiz1=new Quiz();
		quiz1.setQid(qid);
		User user1=new User();
		user1.setId(uid);
		System.out.println(qid+" "+uid);
		List<Result>lis=(this.resultservice.getResultOfUserAndQuiz(quiz1, user1));
	for(Result r:lis)
	{
		System.out.println(r.getMarksScored());
	}
		return ResponseEntity.ok(lis);
		
	}
	
	@GetMapping("/{qid}")
	public ResponseEntity<?> getResultByQuiz(@PathVariable("qid") long qid)
	{
		Quiz quiz1=new Quiz();
		quiz1.setQid(qid);
		List<Result>lis=this.resultservice.getResultOfQuiz(quiz1);
		return ResponseEntity.ok(lis);
		
	}
	
	
	

}
