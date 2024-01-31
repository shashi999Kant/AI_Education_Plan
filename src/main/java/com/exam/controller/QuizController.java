package com.exam.controller;

import com.exam.model.exams.Category;
import com.exam.model.exams.Quiz;
import com.exam.services.CategoryService;
import com.exam.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;
    
    @Autowired
    private CategoryService categoryService;

    //add quiz
    @PostMapping("/category/{categoryId}")
    public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz,
    		@PathVariable Long categoryId) throws Exception
    {
    	Category cat = this.categoryService.getCategory(categoryId);
    	quiz.setCategory(cat);
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }
    //update quiz
    @PutMapping("/")
    public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz)
    {
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }
    //get quiz
    @GetMapping("/")
    public ResponseEntity<?> getQuizzes()
    {
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    //get single quiz	
    @GetMapping("{quizId}")
    public Quiz getSingleQuiz(@PathVariable("quizId") Long qid)
    {
    	System.out.println("Geettting single quiz");
        return this.quizService.getQuiz(qid);
    }
    //delete Quiz
    @DeleteMapping("/{quizId}")
    public void deleteQuiz(@PathVariable("quizId") Long qid)
    {
        System.out.println("Delteing quiz"+qid);
        this.quizService.deleteQuiz(qid);
    }
    
    //get quiz of particular category
    @GetMapping("/category/{categoryId}")
    public List<Quiz> getQuizOfCategory(@PathVariable("categoryId") Long cid) throws Exception
    {
    	Category cat = this.categoryService.getCategory(cid);
    	return (this.quizService.getQuizzesOfCategory(cat));
    	
    }
}
