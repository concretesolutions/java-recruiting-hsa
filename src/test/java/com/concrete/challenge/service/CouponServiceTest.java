package com.concrete.challenge.service;

import com.concrete.challenge.dao.CouponDAO;
import com.concrete.challenge.model.Coupon;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@SpringBootTest
@ComponentScan(basePackages = "com.concrete")
@ContextConfiguration(classes = {RestTemplateAutoConfiguration.class})
public class CouponServiceTest {

    @Mock
    private CouponDAO couponDAO;

    @InjectMocks
    private CouponService service;

    @Test
    public void test(){
        when(couponDAO.getCoupons()).thenReturn(dummyCoupons());
        List<Coupon> coupons = service.findCouponsNotExpired();
        assertThat(coupons.size(),is(equalTo(3)));
    }

    private List<Coupon> dummyCoupons() {
        List<Coupon> coupons = new ArrayList<>();

        coupons.add(new Coupon("COUPON_1", "10% Discount", "Crazy Seller", "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg", "2032-12-01"));
        coupons.add(new Coupon("COUPON_2", "30% Discount", "Mega Seller", "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg", "2011-12-01"));
        coupons.add(new Coupon("COUPON_3", "40% Discount", "The Seller", "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg", "2010-12-01"));
        coupons.add(new Coupon("COUPON_4", "50% Discount", "Crazy Seller", "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg", "2022-12-01"));
        coupons.add(new Coupon("COUPON_5", "90% Discount", "Mega Seller", "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg", "2023-12-01"));

        return coupons;
    }
}
