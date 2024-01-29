package com.exam.model.exams;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "learning_items")
public class LearningItem {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String title;
 private String description;

 @ManyToOne
 @JoinColumn(name = "learning_plan_id")
 private LearningPlan learningPlan;

 @Column(name = "order_in_plan")
 private Integer orderInPlan;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}


public LearningPlan getLearningPlan() {
	return learningPlan;
}

public void setLearningPlan(LearningPlan learningPlan) {
	this.learningPlan = learningPlan;
}

public Integer getOrderInPlan() {
	return orderInPlan;
}

public void setOrderInPlan(Integer orderInPlan) {
	this.orderInPlan = orderInPlan;
}
 
 


}
