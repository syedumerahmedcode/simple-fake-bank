package com.umer.simplefakebank.exception;

public class InvalidRequestAccountException extends RuntimeException {

	private static final String INVALID_REQUEST_ACCOUNT_EXCEPTION = "Invalid request account exception.";

	public InvalidRequestAccountException() {
		super(INVALID_REQUEST_ACCOUNT_EXCEPTION);
	}

}
