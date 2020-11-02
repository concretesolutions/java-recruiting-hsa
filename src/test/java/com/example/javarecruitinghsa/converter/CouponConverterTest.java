package com.example.javarecruitinghsa.converter;

import com.example.javarecruitinghsa.pojo.Coupon;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.text.ParseException;

@RunWith(MockitoJUnitRunner.class)
public class CouponConverterTest {

    @InjectMocks
    CouponConverter converter;

    Coupon[] in;

    @Before
    public void setup() throws IOException {
        in = new ObjectMapper()
                .readValue(new ClassPathResource("cuponList.json").getFile(),
                        Coupon[].class);
    }

    @Test
    public void deleteExpired_ok() throws ParseException {
        Assert.assertNotNull(converter.deleteExpired(in));
    }

    @Test(expected = ParseException.class)
    public void deleteExpired_nok() throws ParseException {
        in[0].setExpiresAt("err");
        Assert.assertNotNull(converter.deleteExpired(in));
    }
}
