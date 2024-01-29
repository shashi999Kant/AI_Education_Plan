package com.exam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exam.model.exams.LearningItem;

public interface LearningItemRepository extends JpaRepository<LearningItem, Long>{
	  List<LearningItem> findByLearningPlanId(Long learningPlanId);
	  
	  @Query("SELECT li FROM LearningItem li WHERE li.learningPlan.id = :learningPlanId ORDER BY li.orderInPlan ASC")
	    List<LearningItem> findAllByLearningPlanIdOrderByOrderInPlanAsc(Long learningPlanId);


}
