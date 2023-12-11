package cl.accenture.bff.categoriescoupons.exception;

import cl.accenture.bff.categoriescoupons.dto.ErrorResponse;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/*
 * Copyright (c) 2023 Boris Molina
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorResponse> handleFeignException(FeignException e, WebRequest request) {
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .timestamp(new Date())
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
                        .message(e.getMessage())
                        .details(request.getDescription(false))
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
