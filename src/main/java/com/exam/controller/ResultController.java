package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.User;
import com.exam.model.exams.Category;
import com.exam.model.exams.Quiz;
import com.exam.model.exams.Result;
import com.exam.services.CategoryService;
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
	
	@Autowired
	private CategoryService categoryService;
	
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
	
	@GetMapping("/{quizId}/{userId}")
	public ResponseEntity<?> getResultByUserAndQuiz(@PathVariable("quizId") long quizId,@PathVariable("userId") long userId)
	{
		Quiz quiz1 = this.quizService.getQuiz(quizId);
		User user1 = this.userService.getUserById(userId);
		System.out.println(quizId+" "+userId);
		List<Result>lis=(this.resultservice.getResultOfUserAndQuiz(quiz1, user1));
	for(Result r:lis)
	{
		System.out.println(r.getMarksScored());
	}
		return ResponseEntity.ok(lis);
		
	} 
	
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<List<Result>> getResultByQuiz(@PathVariable("quizId") long quizId)
	{
		Quiz quiz1 = this.quizService.getQuiz(quizId);
		List<Result>lis=this.resultservice.getResultOfQuiz(quiz1);
		return ResponseEntity.ok(lis);
		
	}
	
	@GetMapping("/user/{userId}")	
	public ResponseEntity<List<Result>> getResultByUser(@PathVariable("userId") long userId)
	{
		User user1 = this.userService.getUserById(userId);
		List<Result> resultOfUser = this.resultservice.getResultOfUser(user1);
		return ResponseEntity.ok(resultOfUser);
		
	}
	
	@GetMapping("/user/{userId}/category/{categoryId}")
	public ResponseEntity<List<Result>> getResultByUserAndCategoryTitle(@PathVariable("userId") long userId,@PathVariable("categoryId") long categoryId) throws Exception{
		User user1 = this.userService.getUserById(userId);
		Category category = this.categoryService.getCategory(categoryId);
		List<Result> resultOfUserAndCategory = this.resultservice.getResultOfUserAndCategory(category, user1);
		
		return new ResponseEntity<List<Result>>(resultOfUserAndCategory , HttpStatus.OK);
		
		
	}
	
	
	

}
