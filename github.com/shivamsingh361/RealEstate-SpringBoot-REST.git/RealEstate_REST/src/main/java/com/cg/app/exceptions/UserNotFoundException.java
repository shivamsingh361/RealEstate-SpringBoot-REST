package com.cg.app.exceptions;

public class UserNotFoundException extends UserException{

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotFoundException(String message) {
		super(message);
	}
	
}
