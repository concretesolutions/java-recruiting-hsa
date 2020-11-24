package com.accenture.prueba.service.impl;

import com.accenture.prueba.client.CouponsClient;
import com.accenture.prueba.dto.CouponsResponseDto;
import com.accenture.prueba.dto.api.CouponApiResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CouponsServiceImplTest {

    @Mock
    private static final CouponsClient couponsClient = Mockito.mock(CouponsClient.class);

    @InjectMocks
    private final CouponsServiceImpl couponsService = new CouponsServiceImpl(couponsClient);

    @BeforeAll
    public static void setUp(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<CouponApiResponse> list = Arrays.asList(
                CouponApiResponse.builder()
                        .id("COUPON_1")
                        .description("50% Discount")
                        .seller("Crazy Seller")
                        .image("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg")
                        .expiresAt(LocalDate.from(dtf.parse("2045-12-01")))
                        .build(),
                CouponApiResponse.builder()
                        .id("COUPON_2")
                        .description("5% Discount")
                        .seller("The Seller")
                        .image("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg")
                        .expiresAt(LocalDate.from(dtf.parse("2042-12-25")))
                        .build(),
                CouponApiResponse.builder()
                        .id("COUPON_3")
                        .description("100% Discount")
                        .seller("Old Seller")
                        .image("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg")
                        .expiresAt(LocalDate.from(dtf.parse("2018-10-01")))
                        .build(),
                CouponApiResponse.builder()
                        .id("COUPON_4")
                        .description("1% Discount")
                        .seller("Mega Discount")
                        .image("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg")
                        .expiresAt(LocalDate.from(dtf.parse("2055-10-01")))
                        .build(),
                CouponApiResponse.builder()
                        .id("COUPON_5")
                        .description("100% Discount")
                        .seller("The Discount")
                        .image("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg")
                        .expiresAt(LocalDate.from(dtf.parse("2016-11-01")))
                        .build());

        Mockito.when(couponsClient.getAll()).thenReturn(list);
    }

    @Test
    void getOnlyNotExpectedTrue() {
        CouponsResponseDto actual = couponsService.get(true);
        CouponsResponseDto expected = CouponsResponseDto.builder().coupons(responseOnlyNotExpectedTrue()).build();
        assertEquals(expected, actual);
    }

    @Test
    void getOnlyNotExpectedFalse() {
        CouponsResponseDto actual = couponsService.get(false);
        CouponsResponseDto expected = CouponsResponseDto.builder().coupons(responseOnlyNotExpectedFalse()).build();
        assertEquals(expected, actual);
    }

    private List<CouponsResponseDto.CouponDto> responseOnlyNotExpectedTrue() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return Arrays.asList(
                CouponsResponseDto.CouponDto.builder()
                        .id("COUPON_1")
                        .descripcion("50% Discount")
                        .vendedor("Crazy Seller")
                        .imagenURI("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg")
                        .fechaExpiracion(LocalDate.from(dtf.parse("2045-12-01")))
                        .build(),
                CouponsResponseDto.CouponDto.builder()
                        .id("COUPON_2")
                        .descripcion("5% Discount")
                        .vendedor("The Seller")
                        .imagenURI("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg")
                        .fechaExpiracion(LocalDate.from(dtf.parse("2042-12-25")))
                        .build(),
                CouponsResponseDto.CouponDto.builder()
                        .id("COUPON_4")
                        .descripcion("1% Discount")
                        .vendedor("Mega Discount")
                        .imagenURI("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg")
                        .fechaExpiracion(LocalDate.from(dtf.parse("2055-10-01")))
                        .build()
        );
    }

    private List<CouponsResponseDto.CouponDto> responseOnlyNotExpectedFalse() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return Arrays.asList(
                CouponsResponseDto.CouponDto.builder()
                        .id("COUPON_1")
                        .descripcion("50% Discount")
                        .vendedor("Crazy Seller")
                        .imagenURI("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg")
                        .fechaExpiracion(LocalDate.from(dtf.parse("2045-12-01")))
                        .build(),
                CouponsResponseDto.CouponDto.builder()
                        .id("COUPON_2")
                        .descripcion("5% Discount")
                        .vendedor("The Seller")
                        .imagenURI("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg")
                        .fechaExpiracion(LocalDate.from(dtf.parse("2042-12-25")))
                        .build(),
                CouponsResponseDto.CouponDto.builder()
                        .id("COUPON_3")
                        .descripcion("100% Discount")
                        .vendedor("Old Seller")
                        .imagenURI("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg")
                        .fechaExpiracion(LocalDate.from(dtf.parse("2018-10-01")))
                        .build(),
                CouponsResponseDto.CouponDto.builder()
                        .id("COUPON_4")
                        .descripcion("1% Discount")
                        .vendedor("Mega Discount")
                        .imagenURI("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg")
                        .fechaExpiracion(LocalDate.from(dtf.parse("2055-10-01")))
                        .build(),
                CouponsResponseDto.CouponDto.builder()
                        .id("COUPON_5")
                        .descripcion("100% Discount")
                        .vendedor("The Discount")
                        .imagenURI("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg")
                        .fechaExpiracion(LocalDate.from(dtf.parse("2016-11-01")))
                        .build());
    }

}