package com.accenture.pruebamanuel.exception;

import java.io.Serializable;
import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Data;

/**
 * Respuesta de excepcion.
 * 
 * @author Manuel Jimenez.
 */
@Data
public class ExceptionResponse implements Serializable {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Code.
	 */
	private String code;

	/**
	 * HttpStatus.
	 */
	private HttpStatus httpStatus;

	/**
	 * Message.
	 */
	private String message;

	/**
	 * Solution.
	 */
	private String solution;

	/**
	 * error time.
	 */
	private Date time;

	/**
	 * Constructor.
	 * 
	 * @param message    message.
	 * @param solution   solution.
	 * @param code       code.
	 * @param httpStatus httpStatus.
	 * @param time       error time.
	 */
	public ExceptionResponse(String message, String solution, String code, HttpStatus httpStatus, Date time) {

		super();
		this.message = message;
		this.solution = solution;
		this.code = code;
		this.httpStatus = httpStatus;
		this.time = time;
	}
}
