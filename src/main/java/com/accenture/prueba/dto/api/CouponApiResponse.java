package com.accenture.prueba.dto.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Objeto de respuesta de respuesta de API de cupones
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Builder
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
    private LocalDate expiresAt;

}
