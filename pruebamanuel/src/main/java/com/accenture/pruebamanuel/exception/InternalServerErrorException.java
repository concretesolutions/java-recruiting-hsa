package com.accenture.pruebamanuel.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

/**
 * Error Interno de la aplicacion.
 * 
 * @author Manuel Jimenez.
 */
@Getter
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends RuntimeException {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Solution.
	 */
	private final String solution;

	/**
	 * Code.
	 */
	private final String code;

	/**
	 * error time
	 */
	private final Date time = new Date();

	/**
	 * Constructor vacio.
	 */
	public InternalServerErrorException() {

		super();
		code = "";
		solution = "";
	}

	/**
	 * Constructor.
	 * 
	 * @param message  message.
	 * @param solution solution.
	 * @param code     code.
	 */
	public InternalServerErrorException(String message, String solution, String code) {

		super(message);
		this.solution = solution;
		this.code = code;
	}

}