package com.accenture.prueba.client.impl;

import com.accenture.prueba.client.CategoriesClient;
import com.accenture.prueba.dto.api.CategoriesApiResponse;
import com.accenture.prueba.exception.ApiCuponesTimeOutException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 * @see CategoriesClient
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class CategoriesClientImpl implements CategoriesClient {

    /**
     * Bean de RestTemplate para peticiones HTTP
     */
    private final RestTemplate restTemplate;

    /**
     * URI de API de categorias
     */
    @Value("${api.categories.uri}")
    private String apiUri;

    /**
     * @see CategoriesClient#getAll()
     */
    @Override
    public CategoriesApiResponse getAll() {
        ResponseEntity<CategoriesApiResponse> response;

        try {
            long initMs = System.currentTimeMillis();
            response = restTemplate.exchange(apiUri, HttpMethod.GET, null, new ParameterizedTypeReference<CategoriesApiResponse>() {
            });
            log.debug("API categorias consumida en {}ms", (System.currentTimeMillis() - initMs));
        } catch (HttpClientErrorException | HttpServerErrorException | ResourceAccessException e) {
            log.error("Error al consumir API de categorias", e);
            throw new ApiCuponesTimeOutException("Error al consumir API");
        }

        return response.getBody();
    }

}
