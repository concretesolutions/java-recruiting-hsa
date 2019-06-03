package com.concrete.challenge.controllers;

import com.concrete.challenge.bean.coupons.external.Coupon;
import com.concrete.challenge.service.CouponsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CouponsControllerTest {

    @InjectMocks
    private CouponsController couponsController;

    @Mock
    private CouponsService couponsService;

    @Test
    public void noCouponsTest() {
        List<Coupon> coupons = getZeroActiveCoupons();
        when(couponsService.getActiveCoupons()).thenReturn(coupons);
        ResponseEntity<List<Coupon>> result = couponsController.getActiveCoupons();
        assertEquals("The HttpStatus should be 204", HttpStatus.NO_CONTENT, result.getStatusCode());
    }

    private List<Coupon> getZeroActiveCoupons() {
        return new ArrayList<>();
    }

    @Test
    public void existsCouponsTest() {
        List<Coupon> coupons = getMoreThanOneActiveCoupons();
        when(couponsService.getActiveCoupons()).thenReturn(coupons);
        ResponseEntity<List<Coupon>> result = couponsController.getActiveCoupons();
        assertEquals("The HttpStatus should be 200", HttpStatus.OK, result.getStatusCode());
    }

    private List<Coupon> getMoreThanOneActiveCoupons() {
        return Arrays.asList(
                Coupon.builder().build(),
                Coupon.builder().build(),
                Coupon.builder().build()
        );
    }


}
