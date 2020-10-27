package com.accenture.challenge.api.exceptions;

public class CouponServiceException extends Exception{
	
	public CouponServiceException(String errorMessage, Throwable e) {
		super(errorMessage, e);
	}

}
