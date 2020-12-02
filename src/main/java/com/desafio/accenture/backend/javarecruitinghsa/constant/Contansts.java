package com.desafio.accenture.backend.javarecruitinghsa.constant;

public final class Contansts {

    /**
     * Constructor privado y que impide la creaci&oacute;n de instancias para este utilitario.
     */
    private Contansts() {
        throw new AssertionError(
                "This class is a utilitary, you can't get a instance for this class: " + this.getClass().getName());
    }

    /* codigo respuesta correcta */
    public static final Integer CODIGO_RESPUESTA_CORRECTA = 0;
    /* codigo respuesta incorrecta */
    public static final Integer CODIGO_RESPUESTA_INCORRECTA = 1;
}
