package com.umer.simplefakebank.exception;

public class AccountNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -5012360156849141861L;
	private static final String ACCOUNT_NOT_FOUND_EXCEPTION = "Account not found exception";

	public AccountNotFoundException() {
		super(ACCOUNT_NOT_FOUND_EXCEPTION);
	}

}
