package com.umer.simplefakebank.exception;

public class InsufficientBalanceException extends RuntimeException{
	
	private static final String INSUFFICIENT_BALANCE_EXCEPTION = "Insufficient balance exception";

	public InsufficientBalanceException() {
		super(INSUFFICIENT_BALANCE_EXCEPTION);
	}

}
