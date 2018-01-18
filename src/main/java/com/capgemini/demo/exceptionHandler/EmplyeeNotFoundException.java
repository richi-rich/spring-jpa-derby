package com.capgemini.demo.exceptionHandler;

public class EmplyeeNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -1817363873256345008L;

	public EmplyeeNotFoundException(String message) {
		super(message);
	}
}
