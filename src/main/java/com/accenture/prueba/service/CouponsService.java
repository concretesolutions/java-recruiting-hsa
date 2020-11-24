package com.accenture.prueba.service;

import com.accenture.prueba.dto.CouponsResponseDto;

/**
 * Servicio de cupones
 */
public interface CouponsService {

    /**
     * Obtener los cupones
     * @param onlyNotExpired Filtro si se quiere solo los cupones no expirados o todos
     *                       false = todos
     *                       true = solo los no expirados
     * @return Objeto mappeado con respuesta de cupones
     */
    CouponsResponseDto get(boolean onlyNotExpired);

}
