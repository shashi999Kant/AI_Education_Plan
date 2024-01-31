package com.exam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.User;
import com.exam.model.exams.Category;
import com.exam.model.exams.Quiz;
import com.exam.model.exams.Result;

public interface ResultRepository extends JpaRepository<Result, Integer> {

	List<Result> findByQuiz(Quiz quiz);

	List<Result> findByUser(User user);

	List<Result> findByQuizAndUser(Quiz quiz, User user);
	
    List<Result> findByUserAndQuiz_Category(User user, Category category);

//	@Query("SELECT r FROM Result r " + "JOIN FETCH r.quiz q " + "JOIN FETCH q.category c " + "JOIN FETCH r.user u "
//			+ "WHERE u.userId = :userId " + "AND c.title = :categoryTitle")
//	List<Result> findResultsByUserAndCategory(@Param("userId") int userId,
//			@Param("categoryTitle") String categoryTitle);

}
