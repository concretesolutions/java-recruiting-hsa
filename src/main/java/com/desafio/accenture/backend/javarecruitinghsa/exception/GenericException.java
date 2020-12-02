package com.desafio.accenture.backend.javarecruitinghsa.exception;


/**
 * Excepci&oacute;n que maneja todas las peticiones y respuestas que van directamente al servicio Ambrosio.
 *
 * @author alvaromontilla
 */
public class GenericException extends Exception {
    private static final long serialVersionUID = 2654143404266925261L;

    private Integer errorCode;

    /**
     * Constructor por defecto que contiene un solo constructor donde se le indica al un mensaje descriptivo del error por
     * el cual la funcionalidad fall&oacute;.
     *
     * @param message Mensaje descriptivo del error.
     */
    public GenericException(String message) {
        super(message);
    }

    public GenericException(String message, Integer errorCode ) {
        super(message);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

}
