package com.accenture.prueba.dto.api;

import lombok.Data;

import java.util.Date;

/**
 * Objeto de respuesta de respuesta de API de cupones
 */
@Data
public class CouponApiResponse {

    /**
     * Id
     */
    private String id;

    /**
     * Descripción
     */
    private String description;

    /**
     * Vendedor
     */
    private String seller;

    /**
     * Imagen URI
     */
    private String image;

    /**
     * Fecha de expiración
     */
    private Date expiresAt;

}
