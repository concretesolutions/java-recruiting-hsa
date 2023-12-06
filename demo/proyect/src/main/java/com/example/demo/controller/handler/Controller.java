package com.example.demo.controller.handler;


import com.example.demo.exception.DomainException;
import com.example.demo.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class Controller {


    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleNotFoundException(DomainException ex) {
        return buildResponse(ex);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> generalError(Exception exception) {

        return buildResponse(exception);
    }

    private ResponseEntity<ErrorResponse> buildResponse( Object detail) {

        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(detail.toString())
                .build();
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_IMPLEMENTED);
    }
}
