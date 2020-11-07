package com.accenture.test.matias.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@Getter
@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE)
public class ServiceUnavailableException extends RuntimeException {

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
     * Empty Constructor.
     */
    public ServiceUnavailableException() {

        super();
        code = "";
        solution = "";
    }

    public ServiceUnavailableException(String message, String solution, String code) {

        super(message);
        this.solution = solution;
        this.code = code;
    }
}
