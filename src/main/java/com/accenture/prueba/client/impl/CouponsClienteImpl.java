package com.accenture.prueba.client.impl;

import com.accenture.prueba.client.CategoriesClient;
import com.accenture.prueba.client.CouponsClient;
import com.accenture.prueba.dto.ApiCouponsResponseCacheWrapper;
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
import java.util.concurrent.TimeUnit;

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
     * Bean de manejador de cache
     */
    private final CacheManager cacheManager;

    /**
     * URI de API de cupones
     */
    @Value("${api.coupons.uri}")
    private String apiUri;

    /**
     * Maximo en minutos que es valida la cache
     */
    @Value("${api.coupons.cache.maxMinutes}")
    private int maxMinutes;

    /**
     * @see CouponsClient#getAll()
     */
    @Override
    public List<CouponApiResponse> getAll() {
        ResponseEntity<List<CouponApiResponse>> response;

        if (isResponseCacheRecent()) {
            return getResponseCache().get().getObject();
        }

        try {
            long initMs = System.currentTimeMillis();
            response = restTemplate.exchange(apiUri, HttpMethod.GET, null, new ParameterizedTypeReference<List<CouponApiResponse>>() {
            });
            log.debug("API cupones consumida en {}ms", (System.currentTimeMillis() - initMs));
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("Error al consumir API de cupones", e);

            Optional<ApiCouponsResponseCacheWrapper> cacheObj = getResponseCache();

            if (!cacheObj.isPresent()){
                // Esta excepcion es lanzada cuando ocurre un error al consultar la API y no se tiene una respuesta guardada en cache
                throw new ApiCuponesTimeOutException("Error consultar API de cupones.");
            }

            return cacheObj.get().getObject();
        }

        Optional.ofNullable(cacheManager.getCache("coupons"))
                .ifPresent(c -> c.put("response", ApiCouponsResponseCacheWrapper.builder().timeStamp(System.currentTimeMillis()).object(response.getBody()).build()));

        return response.getBody();
    }

    /**
     * Metodo que obtiene la respuesta en cache
     * En caso de que no este retorna un Optional vacio
     * @return Optional<ApiCouponsResponseCacheWrapper>
     */
    private Optional<ApiCouponsResponseCacheWrapper> getResponseCache() {
        Optional<Cache> cache = Optional.ofNullable(cacheManager.getCache("coupons"));

        if (!cache.isPresent()){
            return Optional.empty();
        }

        Optional<Cache.ValueWrapper> cacheResponse = Optional.ofNullable(cache.get().get("response"));

        if (!cacheResponse.isPresent()){
            return Optional.empty();
        }

        Optional<Object> valueCache = Optional.ofNullable(cacheResponse.get().get());

        return valueCache.map(o -> (ApiCouponsResponseCacheWrapper) o);
    }

    /**
     * Valida si la cache es reciente en base a los minutos parametrizados
     * En caso de que no exista cache retorna false
     * @return cache reciente o no
     */
    private boolean isResponseCacheRecent() {
        Optional<ApiCouponsResponseCacheWrapper> cacheObj = getResponseCache();

        if (!cacheObj.isPresent()) {
            return false;
        }

        long tmsLast = cacheObj.get().getTimeStamp();
        return (System.currentTimeMillis() - tmsLast) <= TimeUnit.MINUTES.toMillis(maxMinutes);
    }

}
