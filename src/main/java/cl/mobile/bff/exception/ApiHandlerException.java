package cl.mobile.bff.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import cl.mobile.bff.domain.ErrorApi;

@ControllerAdvice
@RestController
public class ApiHandlerException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ApiInternalServerException.class)
	public final ResponseEntity<ErrorApi> hendleApiInternalException(ApiInternalServerException e, WebRequest request) {
		return new ResponseEntity<>(new ErrorApi(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    } 
}
