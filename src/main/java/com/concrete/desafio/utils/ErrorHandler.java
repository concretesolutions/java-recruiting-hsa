package com.concrete.desafio.utils;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class ErrorHandler {

    private static final String DEFAULT_ERROR_CODE = "0000";
  public static ResponseEntity<ErrorDTO> handlerErrorException(Exception ex) {
    return
        new ResponseEntity<ErrorDTO>(
            new ErrorDTO(DEFAULT_ERROR_CODE, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
  }

    public ResponseEntity<ErrorDTO> handlerErrorFeignException(FeignException ex, HttpServletResponse response) {
        return
                new ResponseEntity<ErrorDTO>(
                        new ErrorDTO(Integer.toString(response.getStatus()), ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
