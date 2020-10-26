package cl.mobile.bff.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ApiInternalServerException extends RuntimeException {
	private static final long serialVersionUID = 5477794070042484555L;
	
	public ApiInternalServerException(Exception e) {
		super("Sorry, we have a problem, please call support");
    }
}
