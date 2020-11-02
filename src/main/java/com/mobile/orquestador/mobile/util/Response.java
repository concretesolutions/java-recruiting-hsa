package com.mobile.orquestador.mobile.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {

	private Response() {
	}

	public static <T> ResponseEntity<T> ok(T object) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Param", "Valor");
		return new ResponseEntity<>(object, responseHeaders, HttpStatus.OK);
	}

	public static <T> ResponseEntity<T> noContent(T objeto) {
		return new ResponseEntity<>(objeto, HttpStatus.NO_CONTENT);
	}

	public static <T> ResponseEntity<T> withoutImplementation(T object) {
		return new ResponseEntity<>(object, HttpStatus.NOT_IMPLEMENTED);
	}

	public static <T> ResponseEntity<T> error(T object) {
		return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
