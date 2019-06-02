package com.concrete.challenge.client;

import com.concrete.challenge.bean.coupons.external.Coupon;
import com.concrete.challenge.client.base.AbstractClient;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CouponsClient extends AbstractClient<Coupon> {

    @Override
    public void construct() {
        setClazz(Coupon.class);
        setArrayClazz(Coupon[].class);
        setElementReturn(Coupon.builder().build());
        setArrayReturn(new Coupon[]{});
    }

    public List<Coupon> getCoupons() {
        return Arrays.asList(getObjects(getClientConfiguration().getCouponsUrl()));
    }
}
