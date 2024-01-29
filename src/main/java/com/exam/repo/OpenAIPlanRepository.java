package com.exam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.exams.OpenAIPlan;



public interface OpenAIPlanRepository extends JpaRepository<OpenAIPlan, Long> {


    List<OpenAIPlan> findByUserIdAndLearningPlanId(Long userId, Long learningPlanId);
    
}