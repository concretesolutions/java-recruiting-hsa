package com.concrete.challenge.controller;

import com.concrete.challenge.model.Coupon;
import com.concrete.challenge.service.CouponService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CouponController.class)
@ComponentScan(basePackages = "com.concrete")
@ContextConfiguration(classes = {RestTemplateAutoConfiguration.class})
public class CouponControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CouponService service;

    @Test
    public void shouldReturnEmptyArrayWhenNotExistCoupons() throws Exception {
        List<Coupon> couponList = new ArrayList<>();
        given(service.findCouponsNotExpired()).willReturn(couponList);

        mvc.perform(get("/coupons")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", is(0)));
    }

    @Test
    public void givenFiveCouponsValidThenReturnFiveElements() throws Exception {
        given(service.findCouponsNotExpired()).willReturn(dummyCoupons());
        mvc.perform(get("/coupons")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", is(5)));
    }

    private List<Coupon> dummyCoupons() {
        List<Coupon> coupons = new ArrayList<>();

        coupons.add(new Coupon("COUPON_1", "10% Discount", "Crazy Seller", "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg", "2032-12-01"));
        coupons.add(new Coupon("COUPON_2", "30% Discount", "Mega Seller", "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg", "2033-12-01"));
        coupons.add(new Coupon("COUPON_3", "40% Discount", "The Seller", "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg", "2033-12-01"));
        coupons.add(new Coupon("COUPON_4", "50% Discount", "Crazy Seller", "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg", "2022-12-01"));
        coupons.add(new Coupon("COUPON_5", "90% Discount", "Mega Seller", "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg", "2023-12-01"));

        return coupons;
    }

}
