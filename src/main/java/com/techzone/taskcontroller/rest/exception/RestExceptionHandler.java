package com.techzone.taskcontroller.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.techzone.taskcontroller.service.excepetion.ObjectNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e){
		StandardError error = new StandardError(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
}
