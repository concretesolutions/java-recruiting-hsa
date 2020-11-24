package com.accenture.prueba.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * Objeto de respuesta de cupones
 */
@Data
@Builder
public class CouponsResponseDto {

    /**
     * Lista de cupones
     */
    List<CouponDto> coupons;

    /**
     * Objeto de cupon
     */
    @Data
    @Builder
    public static class CouponDto {

        /**
         * Id
         */
        private String id;

        /**
         * Descripción
         */
        private String descripcion;

        /**
         * Vendedor
         */
        private String vendedor;

        /**
         * Imagen URI
         */
        private String imagenURI;

        /**
         * Fecha de expiración
         */
        private LocalDate fechaExpiracion;
    }

}
