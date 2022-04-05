package com.app.customexception;

public class ProjectCustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public ProjectCustomException(String message) {
		super(message);
	}
}
