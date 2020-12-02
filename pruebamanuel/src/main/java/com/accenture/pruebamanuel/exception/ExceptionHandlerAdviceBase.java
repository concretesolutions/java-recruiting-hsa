package com.accenture.pruebamanuel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.accenture.pruebamanuel.util.Constant;

import lombok.extern.log4j.Log4j2;

/**
 * Controlador generico para Administrar la excepcion de respuesta.
 * 
 * @author Manuel Jimenez.
 */
@Log4j2
public class ExceptionHandlerAdviceBase extends ResponseEntityExceptionHandler {

	/**
	 * Metodo que retorna una excepcion de BadRequestException.
	 * 
	 * @param ex      BadRequestException.
	 * @param request WebRequest
	 * @return retorna un responseEntity con su respectivo Error
	 */
	@ExceptionHandler(BadRequestException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestException(BadRequestException ex,
			WebRequest request) {

		ExceptionResponse exceptionResponse = null;
		if (ex.getMessage() != null && ex.getSolution() != null && ex.getCode() != null) {
			log.error("Exception handler BadRequestException", ex.getMessage());
			exceptionResponse = new ExceptionResponse(ex.getMessage(), ex.getSolution(), ex.getCode(),
					HttpStatus.BAD_REQUEST, ex.getTime());
		} else {
			exceptionResponse = new ExceptionResponse(Constant.BADREQUEST_MESSAGE, Constant.BADREQUEST_SOLUTION,
					Constant.BADREQUEST_CODE, HttpStatus.BAD_REQUEST, ex.getTime());
		}
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Metodo que retorna una excepcion de ServiceUnavailableException.
	 * 
	 * @param ex      ServiceUnavailableException
	 * @param request WebRequest
	 * @return retorna un responseEntity con su respectivo Error
	 */
	@ExceptionHandler(ServiceUnavailableException.class)
	public final ResponseEntity<ExceptionResponse> handleServiceUnavailableException(ServiceUnavailableException ex,
			WebRequest request) {

		ExceptionResponse exceptionResponse = null;
		if (ex.getMessage() != null && ex.getSolution() != null && ex.getCode() != null) {
			log.error("Exception handler ServiceUnavailableException", ex.getMessage());
			exceptionResponse = new ExceptionResponse(ex.getMessage(), ex.getSolution(), ex.getCode(),
					HttpStatus.SERVICE_UNAVAILABLE, ex.getTime());
		} else {
			exceptionResponse = new ExceptionResponse(Constant.SERVICEUNAVAILABLE_MESSAGE,
					Constant.SERVICEUNAVAILABLE_SOLUTION, Constant.SERVICEUNAVAILABLE_CODE,
					HttpStatus.SERVICE_UNAVAILABLE, ex.getTime());
		}
		return new ResponseEntity<>(exceptionResponse, HttpStatus.SERVICE_UNAVAILABLE);
	}

	/**
	 * Metodo que retorna una excepcion de ConflictException.
	 * 
	 * @param ex      ConflictException
	 * @param request WebRequest
	 * @return retorna un responseEntity con su respectivo Error
	 */
	@ExceptionHandler(ConflictException.class)
	public final ResponseEntity<ExceptionResponse> handleConflictException(ConflictException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = null;
		if (ex.getMessage() != null && ex.getSolution() != null && ex.getCode() != null) {
			log.error("Exception handler ConflictException", ex.getMessage());
			exceptionResponse = new ExceptionResponse(ex.getMessage(), ex.getSolution(), ex.getCode(),
					HttpStatus.CONFLICT, ex.getTime());
		} else {
			exceptionResponse = new ExceptionResponse(Constant.CONFLICT_MESSAGE, Constant.CONFLICT_SOLUTION,
					Constant.CONFLICT_CODE, HttpStatus.CONFLICT, ex.getTime());
		}
		return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);
	}

	/**
	 * Metodo que retorna una excepcion de ConflictException.
	 * 
	 * @param ex      ConflictException
	 * @param request WebRequest
	 * @return
	 */
	@ExceptionHandler(InternalServerErrorException.class)
	public final ResponseEntity<ExceptionResponse> handleInternalServerErrorException(InternalServerErrorException ex,
			WebRequest request) {

		ExceptionResponse exceptionResponse = null;
		if (ex.getMessage() != null && ex.getSolution() != null && ex.getCode() != null) {
			log.error("Exception handler InternalServerErrorException", ex.getMessage());
			exceptionResponse = new ExceptionResponse(ex.getMessage(), ex.getSolution(), ex.getCode(),
					HttpStatus.INTERNAL_SERVER_ERROR, ex.getTime());
		} else {
			exceptionResponse = new ExceptionResponse(Constant.INTERNALSERVERERROR_MESSAGE,
					Constant.INTERNALSERVERERROR_SOLUTION, Constant.INTERNALSERVERERROR_CODE,
					HttpStatus.INTERNAL_SERVER_ERROR, ex.getTime());
		}
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
