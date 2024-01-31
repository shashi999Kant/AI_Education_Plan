package com.exam.controller;

import com.exam.model.exams.Question;
import com.exam.model.exams.Quiz;
import com.exam.services.QuestionService;
import com.exam.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;
    

    //add question

    @PostMapping("/quiz/{quizId}")
    public ResponseEntity<?> addQuestion(@RequestBody Question question,@PathVariable Long quizId)
    {
    	Quiz addedQuiz = quizService.getQuiz(quizId);
    	question.setQuiz(addedQuiz);
    	System.out.println(question);
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    //update question
    @PutMapping("/")
    public ResponseEntity<?> updateQuestion(@RequestBody Question question)
    {
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    //get quiz wise questions
    @GetMapping("/all/quiz/{quizId}")
    public ResponseEntity<?> getAllQuestionsOfQuiz(@PathVariable("quizId") Long qid)
    {
        Quiz quiz=this.quizService.getQuiz(qid);
        Set<Question> questions=quiz.getQuestions();
        int totalQuestions=Integer.parseInt(quiz.getNoOfQuestions());
        List list=new ArrayList(questions);
        if(list.size()>totalQuestions)
        {
            list=list.subList(0,totalQuestions+1);
        }
        Collections.shuffle(list);

        return ResponseEntity.ok(list);
    }


    @GetMapping("/quiz/admin/all/{quizId}")
    public ResponseEntity<?> getAllQuestionsOfQuizAdmin(@PathVariable("quizId") Long qid)
    {
    	 Quiz quiz=this.quizService.getQuiz(qid);
      Set<Question>list=this.questionService.getQuestionOfQuiz(quiz);

        return ResponseEntity.ok(list);
    }

    
    //get a single question
    @GetMapping("/{questionId}")
    public Question getQuestion(@PathVariable("questionId") Long qid)
    {
        return this.questionService.getQuestion(qid);
    }
    //delete a single question
    @DeleteMapping("{questionId}")
    public void deleteQuestion(@PathVariable("questionId") Long qid)
    {
        this.questionService.deleteQuestion(qid);
    }
}
