package com.umer.simplefakebank.exception;

public class TransferNotAllowedException extends RuntimeException {

	private static final long serialVersionUID = 2533717266295726951L;
	private static final String TRANSFER_NOT_ALLOWED_EXCEPTION = "Transfer not allowed exception";

	public TransferNotAllowedException() {
		super(TRANSFER_NOT_ALLOWED_EXCEPTION);
	}

}
