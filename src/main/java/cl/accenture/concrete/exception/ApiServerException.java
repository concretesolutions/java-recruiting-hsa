package cl.accenture.concrete.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ApiServerException extends RuntimeException {
	
	private static final Logger logger = LoggerFactory.getLogger(ApiServerException.class);
	
	private static final long serialVersionUID = 1933678985854754311L;

	public ApiServerException(Exception e) {
		super(e.getMessage());
		logger.error(e.getMessage(), e);
	}
}
