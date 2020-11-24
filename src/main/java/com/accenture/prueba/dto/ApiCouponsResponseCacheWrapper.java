package com.accenture.prueba.dto;

import com.accenture.prueba.dto.api.CouponApiResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Objeto Wrapper de datos para cache de API cupones
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class ApiCouponsResponseCacheWrapper {

    /**
     * TimeStamp de cuando se guardo
     */
    private long timeStamp;

    /**
     * Respuesta guardada
     */
    private List<CouponApiResponse> object;

    /**
     * Flag para indicar si es reciente
     */
    private boolean recent;

}
