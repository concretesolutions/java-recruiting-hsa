package com.accenture.test.matias.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.accenture.test.matias.client.CouponClient;
import com.accenture.test.matias.model.Coupon;
import com.accenture.test.matias.util.DateTime;

public class CouponServiceImplTest {

    @InjectMocks
    private CouponServiceImpl couponService;

    @Mock
    private CouponClient couponClient;

    @BeforeEach
    public void init() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getCouponDateStatus() {

        // Date mock -> 2042-12-25
        Date date = new GregorianCalendar(2042, Calendar.DECEMBER, 25).getTime();
        
        // Way to mock the new Date() as given final date.
        final DateTime dt = Mockito.mock(DateTime.class);
        MockitoAnnotations.initMocks(this);
        couponService.dateTime = dt;
        Mockito.when(dt.getDate()).thenReturn(date);
        
        List<Coupon> mockCoupons = getMockCoupons();

        ResponseEntity<List<Coupon>> resp = new ResponseEntity<List<Coupon>>(mockCoupons, HttpStatus.OK);
        Mockito.when(couponClient.getCoupons()).thenReturn(resp);
        List<Coupon> coupons = couponService.getNotExpiredCoupons();

        assertEquals(coupons.size(), 3);
        assertThat(coupons.equals(getMockOutput())).isTrue();

    }

    private List<Coupon> getMockCoupons() {

        Coupon c1 = craeteCoupon("COUPON_1", "50% Discount", "Crazy Seller",
                "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg", "2045-12-01");
        Coupon c2 = craeteCoupon("COUPON_2", "5% Discount", "The Seller",
                "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg", "2042-12-25");
        Coupon c3 = craeteCoupon("COUPON_3", "100% Discount", "Old Seller",
                "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg", "2018-10-01");
        Coupon c4 = craeteCoupon("COUPON_4", "1% Discount", "Mega Discount",
                "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg", "2055-10-01");
        return Stream.of(c1, c2, c3, c4).collect(Collectors.toList());

    }
    
    private List<Coupon> getMockOutput() {
        Coupon c1 = craeteCoupon("COUPON_1", "50% Discount", "Crazy Seller",
                "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg", "2045-12-01");
        Coupon c2 = craeteCoupon("COUPON_2", "5% Discount", "The Seller",
                "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg", "2042-12-25");
        Coupon c4 = craeteCoupon("COUPON_4", "1% Discount", "Mega Discount",
                "https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg", "2055-10-01");
        return Stream.of(c1, c2, c4).collect(Collectors.toList());
    }

    private Coupon craeteCoupon(String id, String description, String seller, String image, String expiresAt) {

        Coupon c = new Coupon();
        c.setId(id);
        c.setDescription(description);
        c.setSeller(seller);
        c.setImage(image);
        c.setExpiresAt(expiresAt);
        return c;
    }
}
