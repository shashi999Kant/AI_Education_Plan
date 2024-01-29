package com.exam.model.exams;

import java.util.Date;

import com.exam.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

//OpenAIPlan.java
@Entity
@Table(name = "openai_plans")
public class OpenAIPlan {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @ManyToOne
 @JoinColumn(name = "user_id")
 private User user;

 @ManyToOne
 @JoinColumn(name = "learning_plan_id")
 private LearningPlan learningPlan;

 @Column(name = "generated_at")
 @Temporal(TemporalType.TIMESTAMP)
 private Date generatedAt;


}
