package cl.accenture.bff.categoriescoupons.controller;

import cl.accenture.bff.categoriescoupons.dto.Coupon;
import cl.accenture.bff.categoriescoupons.service.CouponsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

/*
 * Copyright (c) 2023 Boris Molina
 */
@ExtendWith(MockitoExtension.class)
public class CouponsControllerTest {

    @Mock
    private CouponsService couponsService;

    @InjectMocks
    private CouponsController couponsController;

    @Test
    public void testGetAllCoupons() {
        when(couponsService.getAllCoupons())
                .thenReturn(Collections.singletonList(Coupon.builder().build()));

        final ResponseEntity<List<Coupon>> result = couponsController.getAllCoupons();

        Assertions.assertNotNull(result);
    }

    @Test
    public void testGetValidCoupons() {
        when(couponsService.getValidCoupons())
                .thenReturn(Collections.singletonList(Coupon.builder().build()));

        final ResponseEntity<List<Coupon>> result = couponsController.getValidCoupons();

        Assertions.assertNotNull(result);
    }

}
