package com.accenture.test.matias.util;

/**
 * Util class for constants.
 * 
 * @author Matias Gomez Arancibia.
 *
 */
public class Constants {

    /**
     * Generic solution message.
     */
    public static final String GENERIC_SOLUTION = "Contáctese con un administrador.";

    /**
     * Message when there is an error using the categories API.
     */
    public static final String API_CATEGORY_ERROR = "No es posible obtener las categorias desde la API.";

    /**
     * Message when there is an error using the coupons API.
     */
    public static final String API_COUPON_ERROR = "No es posible obtener los cupones desde la API.";

    /**
     * Generic service code for the category throws.
     */
    public static final String SERVICE_CODE_CATEGORY = "[accenture-matias-test-category-api]";

    /**
     * Generic service code for the coupon throws.
     */
    public static final String SERVICE_CODE_COUPON = "[accenture-matias-test-coupon-api]";

    /**
     * Message for an invalid input for the endpoint
     * getTopRelevanceCategories.
     */
    public static final String MSG_INVALID_CATEGORIES_QUANTITY = "Cantidad de categorias top inválida.";

    /**
     * Error message when ObjectMapper is trying to convert an object and
     * fails.
     */
    public static final String MSG_ERROR_CONVERT_OBJECTMAPPER = "Error al convertir un objeto con ObjectMapper";
}
