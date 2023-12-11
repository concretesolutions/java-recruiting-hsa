package cl.accenture.bff.categoriescoupons.service;

import cl.accenture.bff.categoriescoupons.client.CouponsClient;
import cl.accenture.bff.categoriescoupons.dto.Coupon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static java.time.LocalDate.EPOCH;
import static org.mockito.Mockito.when;

/*
 * Copyright (c) 2023 Boris Molina
 */
@ExtendWith(MockitoExtension.class)
public class CouponsServiceTest {

    @Mock
    private CouponsClient couponsClient;

    @InjectMocks
    private CouponsService couponsService;

    @Test
    public void testGetAllCoupons() {
        when(couponsClient.getCoupons())
                .thenReturn(Collections.singletonList(Coupon.builder().build()));

        final List<Coupon> result = couponsService.getAllCoupons();

        Assertions.assertNotNull(result);
    }

    @Test
    public void testGetValidCoupons() {
        when(couponsClient.getCoupons())
                .thenReturn(Collections.singletonList(buildCoupon()));

        final List<Coupon> result = couponsService.getValidCoupons();

        Assertions.assertNotNull(result);
    }

    private Coupon buildCoupon() {
        return Coupon.builder()
                .expiresAt(EPOCH)
                .build();
    }

}
