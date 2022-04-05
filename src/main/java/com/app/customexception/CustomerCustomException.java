package com.app.customexception;

public class CustomerCustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CustomerCustomException(String message) {
		super(message);
	}
}
