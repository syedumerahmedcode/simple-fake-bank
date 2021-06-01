package com.umer.simplefakebank.exception;

public class AccountNotFoundException extends RuntimeException{
	
	public AccountNotFoundException() {
		super("Account not found exception");
	}

}
