package com.accenture.challenge.api.exceptions;

public class ProxyException extends Exception{
	
	public ProxyException(String errorMessage) {
		super(errorMessage);
	}
	
	public ProxyException(String errorMessage, Throwable e) {
		super(errorMessage, e);
	}


}
