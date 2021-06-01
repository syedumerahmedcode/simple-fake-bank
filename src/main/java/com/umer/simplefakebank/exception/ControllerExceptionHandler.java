package com.umer.simplefakebank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	
	@ExceptionHandler({
		UserNotFoundException.class,
		AccountNotFoundException.class
	})
	public ResponseEntity<String> handleUserNotFoundException(Exception exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());		
	}
	
	@ExceptionHandler({
		InvalidRequestAccountException.class,
		InvalidRequestOperationException.class,
		TransferNotAllowedException.class,
		InsufficientBalanceException.class
	})
	public ResponseEntity<String> handleInvalidRequestAccountexception(Exception exception){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
	}

}
