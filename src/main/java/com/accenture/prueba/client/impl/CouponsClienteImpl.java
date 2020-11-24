package com.accenture.prueba.client.impl;

import com.accenture.prueba.client.CategoriesClient;
import com.accenture.prueba.client.CouponsClient;
import com.accenture.prueba.dto.api.CouponApiResponse;
import com.accenture.prueba.exception.ApiCuponesTimeOutException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @see CategoriesClient
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class CouponsClienteImpl implements CouponsClient {

    /**
     * Bean de RestTemplate para peticiones HTTP
     */
    private final RestTemplate restTemplate;

    /**
     * URI de API de cupones
     */
    @Value("${api.coupons.uri}")
    private String apiUri;

    /**
     * @see CouponsClient#getAll() ()
     */
    @Override
    public List<CouponApiResponse> getAll() {
        ResponseEntity<List<CouponApiResponse>> response;

        try {
            long initMs = System.currentTimeMillis();
            response = restTemplate.exchange(apiUri, HttpMethod.GET, null, new ParameterizedTypeReference<List<CouponApiResponse>>() {
            });
            log.debug("API cupones consumida en {}ms", (System.currentTimeMillis() - initMs));
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("Error al consumir API de cupones", e);
            throw new ApiCuponesTimeOutException("Error al consumir api cupones");
        }

        return response.getBody();
    }
}
