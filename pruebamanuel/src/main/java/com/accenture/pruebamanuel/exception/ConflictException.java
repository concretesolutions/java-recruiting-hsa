package com.accenture.pruebamanuel.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

/**
 * Error Conflictos internos.
 * 
 * @author Manuel Jimenez.
 */
@Getter
@ResponseStatus(code = HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {

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
	public ConflictException() {

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
	public ConflictException(String message, String solution, String code) {

		super(message);
		this.solution = solution;
		this.code = code;
	}

}