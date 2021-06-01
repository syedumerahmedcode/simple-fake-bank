package com.umer.simplefakebank.exception;

public class InvalidRequestAccountException extends IllegalArgumentException {

	private static final long serialVersionUID = -4507090512155353746L;
	private static final String INVALID_REQUEST_ACCOUNT_EXCEPTION = "Invalid request account exception.";

	public InvalidRequestAccountException() {
		super(INVALID_REQUEST_ACCOUNT_EXCEPTION);
	}

}
