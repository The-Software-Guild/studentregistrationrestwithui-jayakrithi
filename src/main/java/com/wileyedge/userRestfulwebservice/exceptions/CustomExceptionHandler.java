package com.wileyedge.userRestfulwebservice.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req){
		ExceptionResponse expResponse = new ExceptionResponse(new Date(), ex.getMessage(), "detailed  description of exception");
		return new ResponseEntity(expResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex,WebRequest req){
		ExceptionResponse expResponse = new ExceptionResponse(new Date(), ex.getMessage(), "user with specfied id is not in the database");
		return new ResponseEntity(expResponse, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse expRes = new ExceptionResponse(new Date(),"Validation Failed",ex.getBindingResult().toString());
		return new ResponseEntity(expRes, HttpStatus.BAD_REQUEST);
	}
}
