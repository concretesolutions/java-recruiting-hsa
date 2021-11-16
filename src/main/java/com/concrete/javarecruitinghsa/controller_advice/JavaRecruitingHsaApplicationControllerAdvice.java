package com.concrete.javarecruitinghsa.controller_advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class JavaRecruitingHsaApplicationControllerAdvice {
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception ex) {
		return ResponseEntity.internalServerError().body(ex.getMessage());
	}
	
}
