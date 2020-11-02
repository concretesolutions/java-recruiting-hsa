package com.concrete.challenge.model;


import com.concrete.challenge.api.Constants;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CouponsTest {

    @Test
    public void shouldReturnFalseWhenCouponIsExpired(){
        String dateToEvaluate = "2019-12-01";
        Coupon coupon =  new Coupon();
        coupon.setExpiresAt(dateToEvaluate);
        assertThat(coupon.valid(), is(equalTo(false)));
    }

    @Test
    public void shouldReturnTrueWhenCouponIsNotExpired(){
        String dateToEvaluate = "2030-12-01";
        Coupon coupon =  new Coupon();
        coupon.setExpiresAt(dateToEvaluate);
        assertThat(coupon.valid(), is(equalTo(true)));
    }

    @Test
    public void shouldReturnFalseWhenExpiredIsBadFormat(){
        String dateToEvaluate = "01-12-2020";
        Coupon coupon =  new Coupon();
        coupon.setExpiresAt(dateToEvaluate);
        assertThat(coupon.valid(), is(equalTo(false)));
    }

    @Test
    public void shouldReturnFalseWhenExpiredIsEmptyValue(){
        String dateToEvaluate = "";
        Coupon coupon =  new Coupon();
        coupon.setExpiresAt(dateToEvaluate);
        assertThat(coupon.valid(), is(equalTo(false)));
    }

    @Test
    public void shouldReturnFalseWhenExpiredIsNullValue(){
        Coupon coupon =  new Coupon();
        coupon.setExpiresAt(null);
        assertThat(coupon.valid(), is(equalTo(false)));
    }

    @Test
    public void shouldReturnTrueWhenExpiredIsCurrentDay(){
        Coupon coupon =  new Coupon();

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.couponsDateFormat);
        String formattedString = localDate.format(formatter);
        coupon.setExpiresAt(formattedString);

        assertThat(coupon.valid(), is(equalTo(true)));
    }

}
