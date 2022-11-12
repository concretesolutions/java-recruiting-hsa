package com.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.dto.ErrorDto;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<ErrorDto> runtimeExceptionHandler(RuntimeException ex) {

		ErrorDto error = ErrorDto.builder().code("500").message(ex.getMessage()).build();
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
