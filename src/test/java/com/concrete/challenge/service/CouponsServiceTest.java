package com.concrete.challenge.service;

import com.concrete.challenge.bean.coupons.external.Coupon;
import com.concrete.challenge.client.CouponsClient;
import com.concrete.challenge.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CouponsServiceTest {

    @InjectMocks
    private CouponsService couponsService;

    @Mock
    private CouponsClient couponsClient;

    @Mock
    private DateUtil dateUtil;

    @Test
    public void clientWithZeroCouponsTest() {
        List<Coupon> coupons = getZeroCoupons();
        LocalDate today = LocalDate.of(2019, 6, 2);

        when(couponsClient.getCoupons()).thenReturn(coupons);
        when(dateUtil.getToday()).thenReturn(today);
        List<Coupon> result = couponsService.getActiveCoupons();
        assertEquals("The result should be zero", 0, result.size());
    }

    private List<Coupon> getZeroCoupons() {
        return new ArrayList<>();
    }

    @Test
    public void clientWithAllExpiredCouponsTest() {
        List<Coupon> coupons = getAllExpiredCoupons();
        LocalDate today = LocalDate.of(2019, 6, 2);

        when(couponsClient.getCoupons()).thenReturn(coupons);
        when(dateUtil.getToday()).thenReturn(today);

        List<Coupon> result = couponsService.getActiveCoupons();
        assertEquals("The result should be zero", 0, result.size());
    }

    private List<Coupon> getAllExpiredCoupons() {
        return Arrays.asList(
                Coupon.builder()
                        .expiresAt("2019-06-01")
                        .build(),
                Coupon.builder()
                        .expiresAt("2018-06-01")
                        .build(),
                Coupon.builder()
                        .expiresAt("2019-05-31")
                        .build(),
                Coupon.builder()
                        .expiresAt("1970-01-01")
                        .build(),
                Coupon.builder()
                        .expiresAt("1987-09-12")
                        .build()
        );
    }

    @Test
    public void clientWithAllButOneCouponActiveTest() {
        List<Coupon> coupons = getAllButOneActiveCoupon();
        LocalDate today = LocalDate.of(2019, 6, 2);

        when(couponsClient.getCoupons()).thenReturn(coupons);
        when(dateUtil.getToday()).thenReturn(today);

        List<Coupon> result = couponsService.getActiveCoupons();
        assertEquals("The result should be one", 1, result.size());
    }

    private List<Coupon> getAllButOneActiveCoupon() {
        return Arrays.asList(
                Coupon.builder()
                        .expiresAt("2019-06-02")
                        .build(),
                Coupon.builder()
                        .expiresAt("2019-06-01")
                        .build(),
                Coupon.builder()
                        .expiresAt("2019-05-31")
                        .build(),
                Coupon.builder()
                        .expiresAt("1970-01-01")
                        .build(),
                Coupon.builder()
                        .expiresAt("1987-09-12")
                        .build()
        );
    }

    @Test
    public void clientWithMoreThanOneCouponActiveTest() {
        List<Coupon> coupons = getMoreThanOneActiveCoupon();
        LocalDate today = LocalDate.of(2019, 6, 2);

        when(couponsClient.getCoupons()).thenReturn(coupons);
        when(dateUtil.getToday()).thenReturn(today);

        List<Coupon> result = couponsService.getActiveCoupons();
        assertEquals("The result should be greater than zero", 2, result.size());
    }

    private List<Coupon> getMoreThanOneActiveCoupon() {
        return Arrays.asList(
                Coupon.builder()
                        .expiresAt("2019-06-03")
                        .build(),
                Coupon.builder()
                        .expiresAt("2019-06-02")
                        .build(),
                Coupon.builder()
                        .expiresAt("2019-05-31")
                        .build(),
                Coupon.builder()
                        .expiresAt("1970-01-01")
                        .build(),
                Coupon.builder()
                        .expiresAt("1987-09-12")
                        .build()
        );
    }
}
