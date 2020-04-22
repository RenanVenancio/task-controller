package com.techzone.taskcontroller.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> validationError(MethodArgumentNotValidException e){
		
		ValidationError errors = new ValidationError("Erro de validação", HttpStatus.BAD_REQUEST.value());
		
		for(FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			errors.addError(new FieldErrorMessage(fieldError.getField(), fieldError.getDefaultMessage()));
		}
		
		System.out.println(e.getCause());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
}
