package com.desafio.accenture.backend.javarecruitinghsa.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Utilitario para manejar objetos y json.
 *
 */
public final class JsonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    private JsonUtil() {
        throw new AssertionError(
            "You can't get an instance for \"" + this.getClass().getName() + "\", because is a utilitary");
    }

    /**
     * Convierte una salida JSON a un objeto simple. Esto <b>NO</b> convierte una colecci&oacute;n, para ello utilizar
     * la funci&oacute;n {@link JsonUtil#jsonToObjectList(String, Class)}.
     *
     * @param json      JSON a transformar.
     * @param typeClass Clase de destino en que se representa el objeto JSON.
     * @param <T>       Tipo de salida, o de asignaci&oacute;n que tendr&aacute; el objeto, relacionado a typeClass.
     * @return JSON representado en un objeto.
     */
    public static <T> T jsonToObject(String json, Class<T> typeClass) {
        Objects.requireNonNull(json,
            "The JSON String cannot be null");
        Objects.requireNonNull(typeClass,
            "The type class cannot be null");
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (isValidJSON(json)) {
                return mapper.readValue(json,
                    mapper.getTypeFactory().constructType(typeClass));
            }
        } catch (IOException e) {
            LOGGER.error("The JSON input cannot be transformed: {}",
                e.getMessage());
        }
        return null;
    }

    /**
     * Determina si una representación de un objeto en JSON puede ser convertida o no a un objeto. Esto valida si tiene
     * una estructura válida y consistente para ser convertida.
     *
     * @param json JSON de entrada.
     * @return <b>true</b>: Si el JSON de entrada es válido. <b>false</b>: En caso contrario.
     */
    public static boolean isValidJSON(String json) {
        JsonParser parser = null;
        try {
            parser = new ObjectMapper().getFactory().createParser(json);
            while (true) {
                if (parser.nextToken() == null) {
                    break;
                }
            }
            return true;
        } catch (IOException e) {
            LOGGER.error("The JSON representation is not valid: {}",
                e.getMessage());
        } finally {
            if (parser != null) {
                try {
                    parser.close();
                } catch (IOException e) {
                    LOGGER.warn("The JSON parser could not closed: {}",
                        e.getMessage());
                }
            }
        }
        return false;
    }

    /**
     * Convierte una salida JSON a una colección de objetos {@link List}.
     *
     * @param json                      JSON a transformar.
     * @param typeCollectionObjectClass Clase de destino que representa la colección de objetos dentro del JSON.
     * @param <T>                       Tipo de salida, o de asignaci&oacute;n que tendr&aacute;n los objetos,
     *                                  relacionado a typeCollectionObjectClass.
     * @return JSON representado en una colección de objetos.
     */
    public static <T> List<T> jsonToObjectList(String json, Class<T> typeCollectionObjectClass) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (isValidJSON(json)) {
                return mapper.readValue(json,
                    mapper.getTypeFactory().constructCollectionType(List.class,
                        typeCollectionObjectClass));
            }
        } catch (IOException e) {
            LOGGER.error("The JSON cannot transformed into a object list: {}",
                e.getMessage());
        }
        return Collections.emptyList();
    }

    /**
     * Determina si una clase es un tipo o hija de ({@link Collection})
     *
     * @param typeClass Clase a evaluar.
     * @param <T>       Tipo de la clase.
     * @return <b>true</b>: Si la clase ingresada es una colección o hija de ésta; <b>false</b>: En caso contrario.
     */
    public static <T> boolean isCollectionType(Class<T> typeClass) {
        return Collection.class.isAssignableFrom(typeClass);
    }

    /**
     * Convierte un objeto en una salida JSON.
     *
     * @param obj Objeto a transformar.
     * @return La representación del objeto en JSON.
     */
    public static String objectToJson(Object obj) {
        return JsonUtil.objectToJson(obj,
            false);
    }

    /**
     * Convierte un objeto en una salida JSON.
     *
     * @param obj         Objeto a transformar.
     * @param isFormatted Formatea la salida del JSON.
     * @return La representación del objeto en JSON.
     */
    public static String objectToJson(Object obj, boolean isFormatted) {
        ObjectMapper objectMapper = new ObjectMapper();
        if (isFormatted) {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        }
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LOGGER.error("The object cannot representated into a JSON: {}",
                e.getMessage());
        }
        return "";
    }

}
