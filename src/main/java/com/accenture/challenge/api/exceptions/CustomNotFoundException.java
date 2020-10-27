package com.accenture.challenge.api.exceptions;

public class CustomNotFoundException extends Exception{
	
	public CustomNotFoundException(String errorMessage) {
		super(errorMessage);
	}
	
	public CustomNotFoundException(String errorMessage, Throwable e) {
		super(errorMessage, e);
	}

}
