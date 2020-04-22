package com.techzone.taskcontroller.rest.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{
	
	public List<FieldErrorMessage> fields = new ArrayList<>();
	
	public ValidationError(String msg, Integer status) {
		super(msg, status);
		
	}

	public List<FieldErrorMessage> getFields() {
		return fields;
	}

	public void addError(FieldErrorMessage error) {
		this.fields.add(error);
	}
		
}
