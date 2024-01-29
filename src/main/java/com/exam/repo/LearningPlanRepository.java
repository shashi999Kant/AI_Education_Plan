package com.exam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.exams.LearningPlan;

public interface LearningPlanRepository  extends JpaRepository<LearningPlan, Long>{
	
	List<LearningPlan> getAllLearningPlansByUser_Id(Long userId);

}
