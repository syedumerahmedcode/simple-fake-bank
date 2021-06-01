package com.umer.simplefakebank.exception;

public class InsufficientBalanceException extends RuntimeException{
	
	private static final long serialVersionUID = 5431696955279442349L;
	private static final String INSUFFICIENT_BALANCE_EXCEPTION = "Insufficient balance exception";

	public InsufficientBalanceException() {
		super(INSUFFICIENT_BALANCE_EXCEPTION);
	}

}
