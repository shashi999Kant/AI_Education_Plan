package com.exam.model.exams;

import java.util.Date;
import java.util.List;

import com.exam.model.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "learning_plans")
public class LearningPlan {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @ManyToOne
 @JoinColumn(name = "user_id")
 private User user;


 @Column(name = "start_date")
 private Date startDate;

 @Column(name = "end_date")
 private Date endDate;

 @OneToMany(mappedBy = "learningPlan", cascade = CascadeType.ALL)
 private List<LearningItem> learningItems;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Date getStartDate() {
	return startDate;
}

public void setStartDate(Date startDate) {
	this.startDate = startDate;
}

public Date getEndDate() {
	return endDate;
}

public void setEndDate(Date endDate) {
	this.endDate = endDate;
}

public List<LearningItem> getLearningItems() {
	return learningItems;
}

public void setLearningItems(List<LearningItem> learningItems) {
	this.learningItems = learningItems;
}


}
