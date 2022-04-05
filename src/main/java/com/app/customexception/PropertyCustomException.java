package com.app.customexception;

public class PropertyCustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public PropertyCustomException(String message) {
		super(message);
	}
}
