package com.techzone.taskcontroller.rest.exception;

public class FieldErrorMessage {
	
	public String field;
	public String message;
	
	public FieldErrorMessage() {
		
	}
	
	public FieldErrorMessage(String field, String message) {
		this.field = field;
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	
	
}
