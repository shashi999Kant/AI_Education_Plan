package com.exam.exception;


public class ResourceNotFoundException extends RuntimeException {

	String resourseName;
	String fieldName;
	Long fieldValue;
	String feildValueString;
	
	public ResourceNotFoundException(String resourseName, String fieldName, Long categoryId) {
		super(String.format("%s not found with this name %s : %s", resourseName, fieldName, categoryId));
		this.resourseName = resourseName;
		this.fieldName = fieldName;
		this.fieldValue = categoryId;
	}
	

	public String getResourseName() {
		return resourseName;
	}


	public void setResourseName(String resourseName) {
		this.resourseName = resourseName;
	}


	public String getFieldName() {
		return fieldName;
	}


	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


	public Long getFieldValue() {
		return fieldValue;
	}


	public void setFieldValue(Long fieldValue) {
		this.fieldValue = fieldValue;
	}


	public String getFeildValueString() {
		return feildValueString;
	}


	public void setFeildValueString(String feildValueString) {
		this.feildValueString = feildValueString;
	}


	public ResourceNotFoundException(String resourseName, String fieldName, String feildValueString) {
		super(String.format("%s not found with this name %s : %l", resourseName, fieldName, feildValueString));
		this.resourseName = resourseName;
		this.fieldName = fieldName;
		this.feildValueString = feildValueString;
	}
	
	
	
}
