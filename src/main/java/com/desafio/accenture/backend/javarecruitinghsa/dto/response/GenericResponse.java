package com.desafio.accenture.backend.javarecruitinghsa.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.websocket.server.ServerEndpoint;
import java.io.Serializable;
import java.util.Objects;


/**
 * Respuesta gen&eacute;rica, clase madre de todas las respuestas de los servicios. Si hay un servicio que no
 * contenga ning&uacute;n parametro adicional a esta clase, se debe crear de igual manera un response concreto sin
 * atributos, extendiendo esta clase y sobrescribiendo sus atributos.
 *
 * @param <T> Clase hija que est&aacute; extendiendo esta clase.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class GenericResponse<T extends GenericResponse> implements Serializable {
    private static final long serialVersionUID = -8334268935782633442L;

    /**
     * Tipo de clase de la cual extiende esta clase. Se necesita para evitar un casteo redundante en sus clases
     * heredadas.
     */
    private final Class<? extends T> childType;

    @JsonProperty(value = "id")
    private Integer codResponse;


    @JsonProperty(value = "message")
    private String message;

    /**
     * Constructor que contiene la clase que se va a extender. Esto se hace para evitar hacer un casteo redundante a la
     * hora de setear los atributos:
     * <p>
     * <ul>
     *     <li><b>id</b>: C&oacute;digo del response.</li>
     *     <li><b>title</b>: T&iacute;tulo del response, esto se puede usar para colocarlo como t&iacute;tulo de ventana
     *                emergente.</li>
     *     <li><b>message</b>: Mensaje o cuerpo del response.</li>
     * </ul>
     * </p>
     *
     * @param childType La clase a la cual pertenece la sub-clase
     */
    public GenericResponse(Class<? extends T> childType) {
        this.childType = Objects.requireNonNull(childType, "The sub-class type cannot be null");
    }

    /**
     * Construcci&oacute;n gen&eacute;rica de una respuesta satisfactoria del servicio. Delega la responsabilidad a
     * todos sus hijos
     * a implementar la manera en como responderan.
     * @return Una respuesta satisfactoria del servicio.
     */
    public abstract T buildSuccessResponse();

    /**
     * Construcci&oacute;n gen&eacute;rica de una respuesta erronea del servicio. Delega la responsabilidad a todos sus
     * hijos a implementar la menera en como mandar&aacute;n o expondr&aacute;n las respuestas erroneas.
     * @param <X> Cualquier sub-clase de {@link Exception}
     * @param e Excepci&oacute;n a procesar.
     * @return Una respuesta erronea del servicio.
     */
    public abstract <X extends Exception> T buildErrorResponse(X e);

}
