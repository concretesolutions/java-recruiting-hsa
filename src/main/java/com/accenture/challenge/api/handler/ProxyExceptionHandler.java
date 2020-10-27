package com.accenture.challenge.api.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.accenture.challenge.api.exceptions.CustomNotFoundException;
import com.accenture.challenge.api.exceptions.ProxyException;
import com.accenture.challenge.api.rs.CouponResponse;
import com.accenture.challenge.api.rs.Status;
import com.accenture.challenge.api.utils.Constant;

@RestControllerAdvice
public class ProxyExceptionHandler {

	
	@ExceptionHandler(ProxyException.class)
	public ResponseEntity<CouponResponse> handleProxyException(ProxyException ex){
		
		CouponResponse response = new CouponResponse();
		response.setStatus(ex.getMessage());
			Status status = new Status();
			status.setCode(-1);
			status.setMessage(Constant.SERVICE_ERROR);
		response.setServiceStatus(status);
		
		return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
		
	}
	
	
	@ExceptionHandler(CustomNotFoundException.class)
	public ResponseEntity<CouponResponse> handleCustomNotFoundException(CustomNotFoundException ex){
		
		CouponResponse response = new CouponResponse();
		response.setStatus(ex.getMessage());
			Status status = new Status();
			status.setCode(-1);
			status.setMessage(Constant.SERVICE_ERROR);
		response.setServiceStatus(status);
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		
	}
	
}
