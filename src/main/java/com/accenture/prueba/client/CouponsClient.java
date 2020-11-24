package com.accenture.prueba.client;

import com.accenture.prueba.dto.api.CouponApiResponse;

import java.util.List;

/**
 * Cliente de API cupones
 */
public interface CouponsClient {

    /**
     * Obtener todos los cupones
     * @return Objeto con todas los cupones de la API
     */
    List<CouponApiResponse> getAll();

}
