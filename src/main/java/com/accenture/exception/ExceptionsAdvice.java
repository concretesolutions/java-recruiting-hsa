package com.accenture.exception;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.accenture.dto.APIErrorDTO;

public class ExceptionsAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ GenericNotFoundException.class })
	public ResponseEntity<APIErrorDTO> handleNotFoundException(GenericNotFoundException ex, WebRequest request) {
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		APIErrorDTO apiError = buildError(httpStatus, ex, request);

		return new ResponseEntity<>(apiError, httpStatus);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<APIErrorDTO> handleAll(Exception ex, WebRequest request) {
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		APIErrorDTO apiError = buildError(httpStatus, ex, request);

		return new ResponseEntity<>(apiError, httpStatus);
	}

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<APIErrorDTO> unauthorizedException(ServiceException ex, WebRequest request) {
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		APIErrorDTO apiError = buildError(httpStatus, ex, request);

		return new ResponseEntity<>(apiError, httpStatus);
	}

	@Override
	protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		APIErrorDTO apiError = buildError(httpStatus, ex, request);

		return new ResponseEntity<>(apiError, httpStatus);
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		APIErrorDTO apiError = buildError(httpStatus, ex, request);

		return new ResponseEntity<>(apiError, httpStatus);
	}

	private APIErrorDTO buildError(HttpStatus httpStatus, Exception ex, WebRequest request) {

		return APIErrorDTO.builder().status(httpStatus.value()).message(httpStatus.getReasonPhrase())
				.detail(ex.getMessage()).build();
	}

}
