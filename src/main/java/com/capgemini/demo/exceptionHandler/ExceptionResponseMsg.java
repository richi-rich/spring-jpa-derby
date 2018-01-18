package com.capgemini.demo.exceptionHandler;

public class ExceptionResponseMsg {

	String errorCode;
	String message;
	
	public ExceptionResponseMsg(){		
	}
	
	public ExceptionResponseMsg(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Exception occured - [errorCode=" + errorCode + ", message=" + message + "]";
	}
	
}
