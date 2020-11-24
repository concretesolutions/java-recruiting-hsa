package com.accenture.prueba.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * Objeto de respuesta de cupones
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Builder
public class CouponsResponseDto {

    /**
     * Lista de cupones
     */
    List<CouponDto> coupons;

    /**
     * Objeto de cupon
     */

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @EqualsAndHashCode
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
