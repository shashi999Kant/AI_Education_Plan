package com.exam.payload;

import com.exam.model.User;

public class jwtAuthResponce {
	
	private String token;
	private User user;
	public jwtAuthResponce() {
		super();
	}
	public jwtAuthResponce(String token, User user) {
		super();
		this.token = token;
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
