package com.app.GlobalExceptionHandling;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.custom_exceptions.ResourceNotFoundExceptions;
import com.app.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		System.out.println("in methodArgumentNotValidException" + e);
		List<FieldError> fieldErrors=e.getFieldErrors();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldErrors);
	} 
	
	
	@ExceptionHandler(ResourceNotFoundExceptions.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ApiResponse handleResourceNotFoundException(ResourceNotFoundExceptions e ) {
		System.out.println("in resource not found"+e);
		return new ApiResponse(e.getMessage());
	}
	
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public ApiResponse handleAnyException(RuntimeException e) {
		System.out.println("In catch all" + e);
		return new ApiResponse(e.getMessage());
	}
	
	
}
