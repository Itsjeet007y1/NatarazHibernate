package com.app.exception;

public class InsufficientAccountBalanceException extends Exception {
	public InsufficientAccountBalanceException(String msg) {
		super(msg);
	}
}
