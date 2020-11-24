package com.accenture.prueba.client.impl;

import com.accenture.prueba.client.CategoriesClient;
import com.accenture.prueba.client.CouponsClient;
import com.accenture.prueba.dto.api.CouponApiResponse;
import com.accenture.prueba.exception.ApiCuponesTimeOutException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    private final CacheManager cacheManager;

    /**
     * @see CouponsClient#getAll()
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
            Optional<Cache> cache = Optional.ofNullable(cacheManager.getCache("coupons"));

            if (!cache.isPresent()){
                throw new ApiCuponesTimeOutException("Error al consumir API de cupones");
            }

            Optional<Cache.ValueWrapper> cacheResponse = Optional.ofNullable(cache.get().get("response"));

            if (!cacheResponse.isPresent()){
                throw new ApiCuponesTimeOutException("Error al consumir API de cupones");
            }

            Optional<Object> valueCache = Optional.ofNullable(cacheResponse.get().get());

            if (!valueCache.isPresent()){
                throw new ApiCuponesTimeOutException("Error al consumir API de cupones");
            }

            return ((List<?>) valueCache.get()).stream().map(r -> (CouponApiResponse) r).collect(Collectors.toList());
        }

        Optional.ofNullable(cacheManager.getCache("coupons")).ifPresent(cache -> cache.put("response", response.getBody()));

        return response.getBody();
    }
}
