package com.umer.simplefakebank.exception;

public class InvalidRequestOperationException extends IllegalArgumentException {

	private static final long serialVersionUID = 34407085956770689L;
	private static final String INVALID_REQUEST_OPERATION_EXCEPTION = "Invalid request operation exception.";

	public InvalidRequestOperationException() {
		super(INVALID_REQUEST_OPERATION_EXCEPTION);
	}

}
