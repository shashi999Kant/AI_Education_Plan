package com.exam.aiWork;

import java.util.ArrayList;
import java.util.List;

public class ChatRequest {

    private String model;
    private List<Message> messages;
    private int n=1;
    private double temperature;
    private int max_tokens = 80;

  

	public ChatRequest(String model, String prompt) {
        this.model = model;
        
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user", prompt));
        this.max_tokens=20;
    }

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<Message> getMessages() {
		return messages;
	}
  public int getMax_tokens() {
		return max_tokens;
	}

	public void setMax_tokens(int max_tokens) {
		this.max_tokens = max_tokens;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

    // getters and setters
}
