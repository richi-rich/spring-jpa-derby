package com.capgemini.demo.exceptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(EmplyeeNotFoundException.class)
	public ResponseEntity<ExceptionResponseMsg> employeeRecordNotFound(EmplyeeNotFoundException empNotFound){
		System.out.print("used this exception"+ getResponseEntity(HttpStatus.NOT_FOUND, empNotFound.getMessage(),
				 new HttpHeaders()));
		return getResponseEntity(HttpStatus.NOT_FOUND, empNotFound.getMessage(),
				 new HttpHeaders());
	}
	
	private ResponseEntity<ExceptionResponseMsg> getResponseEntity(HttpStatus httpStatus, String errorMessage,
			HttpHeaders httpHeaders) {
		ExceptionResponseMsg expResponse = new ExceptionResponseMsg();
		expResponse.setErrorCode(httpStatus.toString());
		expResponse.setMessage(errorMessage);
		
		return new ResponseEntity<ExceptionResponseMsg>(expResponse, httpHeaders, httpStatus);
	}

}
