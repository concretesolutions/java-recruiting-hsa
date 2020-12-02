package com.accenture.pruebamanuel.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

/**
 * Error Request (campos malos, faltan datos, etc).
 * 
 * @author Manuel Jimenez.
 */
@Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

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
    public BadRequestException() {

        super();
        code = "";
        solution = "";
    }
    
	/**
	 * Constructor.
	 * 
	 * @param message message.
	 */
	public BadRequestException(String message, String solution, String code) {
		super(message);
		this.solution = solution;
        this.code = code;
	}

}