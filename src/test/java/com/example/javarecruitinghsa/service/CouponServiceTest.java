package com.example.javarecruitinghsa.service;

import com.example.javarecruitinghsa.converter.CouponConverter;
import com.example.javarecruitinghsa.pojo.Coupon;
import com.example.javarecruitinghsa.repository.CouponRepository;
import com.example.javarecruitinghsa.service.impl.CouponServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CouponServiceTest {

    @InjectMocks
    CouponServiceImpl service;
    @Mock
    CouponRepository couponRepository;
    @Mock
    CouponConverter couponConverter;
    List<Coupon> couponList;
    Coupon[] coupons;

    @Before
    public void setup() throws IOException {
        couponList = new ObjectMapper()
                .readValue(new ClassPathResource("cuponList.json").getFile(),
                        new TypeReference<List<Coupon>>() {
                        });
        coupons = new ObjectMapper()
                .readValue(new ClassPathResource("cuponList.json").getFile(),
                        Coupon[].class);
    }

    @Test
    public void aviable_ok() throws ParseException {
        when(couponRepository.findCouponList())
                .thenReturn(coupons);
        when(couponConverter.deleteExpired(any(Coupon[].class)))
                .thenReturn(couponList);
        Assert.assertNotNull(service.aviable());
    }

    @Test
    public void aviable_nok() throws ParseException {
        when(couponRepository.findCouponList())
                .thenReturn(coupons);
        when(couponConverter.deleteExpired(any(Coupon[].class)))
                .thenThrow(new ParseException("err", HttpStatus.BAD_REQUEST.value()));
        Assert.assertEquals(service.aviable(), Optional.empty());
    }
}
