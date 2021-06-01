package com.umer.simplefakebank.exception;

public class AccountNotFoundException extends RuntimeException{
	
	private static final String ACCOUNT_NOT_FOUND_EXCEPTION = "Account not found exception";

	public AccountNotFoundException() {
		super(ACCOUNT_NOT_FOUND_EXCEPTION);
	}

}
