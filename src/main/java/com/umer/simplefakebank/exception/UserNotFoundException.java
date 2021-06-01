package com.umer.simplefakebank.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5761977887396228764L;
	private static final String USER_NOT_FOUND_EXCEPTION = "User not found exception.";

	public UserNotFoundException() {
		super(USER_NOT_FOUND_EXCEPTION);
	}

}
