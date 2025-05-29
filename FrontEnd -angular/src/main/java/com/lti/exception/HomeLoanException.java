package com.lti.exception;

public class HomeLoanException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public HomeLoanException() {
		super();
	}
	
	public HomeLoanException(String msg) {
		super(msg);
	}
}