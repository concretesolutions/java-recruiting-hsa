package com.accenture.prueba.exception;

import lombok.Getter;

/**
 * Excepcion para cuando no se puede obtener la API
 */
@Getter
public class ApiCuponesTimeOutException extends RuntimeException {

    /**
     * Constructor por defecto con un mensaje
     * @param message Mensaje
     */
    public ApiCuponesTimeOutException(String message) {
        super(message);
    }

}
