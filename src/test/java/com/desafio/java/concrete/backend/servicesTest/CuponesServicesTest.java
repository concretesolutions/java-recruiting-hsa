package com.desafio.java.concrete.backend.servicesTest;

import com.desafio.java.concrete.backend.services.CuponesServices;
import com.desafio.java.concrete.backend.services.RestServices;
import com.desafio.java.concrete.backend.settings.ApiSettings;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;

public class CuponesServicesTest {
    @InjectMocks
    CuponesServices cuponesServices;
    @Mock
    ApiSettings apiSettings;

    @Mock
    RestServices restServices;

    @Test
    public void getCarruselCuponesTest() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(restServices.responseEntity(anyString()))
                .thenReturn(responseEntity());
        Mockito.when(apiSettings.getCuponURL())
                .thenReturn("https://cs-hsa-api-coupons.herokuapp.com/coupons");

        String expected = "[{\"iconImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"name\":\"50% Discount\",\"expiresAt\":2395710000000},{\"iconImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"name\":\"5% Discount\",\"expiresAt\":2303089200000},{\"iconImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"name\":\"1% Discount\",\"expiresAt\":2705972400000}]";

        String test = cuponesServices.getCarruselCupones();
        Assert.assertEquals("Respuesta Esperada", expected, test);

    }
    @Test
    public void getCarruselCuponesFailTest() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(restServices.responseEntity(anyString()))
                .thenReturn(responseEntityFail());
        Mockito.when(apiSettings.getCuponURL())
                .thenReturn("https://cs-hsa-api-coupons.herokuapp.com/coupons");

        String test = cuponesServices.getCarruselCupones();
        assertThat(test).isNotNull();

    }

    public ResponseEntity responseEntity() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<?> responseEntity = new ResponseEntity<>(
                "[{\"id\":\"COUPON_1\",\"description\":\"50% Discount\",\"seller\":\"Crazy Seller\",\"image\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"expiresAt\":\"2045-12-01\"},{\"id\":\"COUPON_2\",\"description\":\"5% Discount\",\"seller\":\"The Seller\",\"image\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"expiresAt\":\"2042-12-25\"},{\"id\":\"COUPON_3\",\"description\":\"100% Discount\",\"seller\":\"Old Seller\",\"image\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"expiresAt\":\"2018-10-01\"},{\"id\":\"COUPON_4\",\"description\":\"1% Discount\",\"seller\":\"Mega Discount\",\"image\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"expiresAt\":\"2055-10-01\"},{\"id\":\"COUPON_5\",\"description\":\"100% Discount\",\"seller\":\"The Discount\",\"image\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"expiresAt\":\"2016-11-01\"}]",
                header,
                HttpStatus.resolve(200)
        );
        return responseEntity;
    }
    public ResponseEntity responseEntityFail() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<?> responseEntity = new ResponseEntity<>(
                "{\"success\":false,\"message\":\"NONK\"}",
                header,
                HttpStatus.resolve(500)
        );
        return responseEntity;
    }
}
