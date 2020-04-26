package com.cg.app.exceptions;

public class UserAlreadyExistException extends Exception {

	public UserAlreadyExistException() {
		super();
	}

	public UserAlreadyExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UserAlreadyExistException(String arg0) {
		super(arg0);
	}

}
