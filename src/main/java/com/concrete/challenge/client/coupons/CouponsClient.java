package com.concrete.challenge.client.coupons;

import com.concrete.challenge.bean.coupons.external.Coupon;
import com.concrete.challenge.client.base.AbstractClient;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CouponsClient
        extends AbstractClient<Coupon>
        implements CouponsRepository {

    @Override
    public void construct() {
        setClazz(Coupon.class);
        setArrayClazz(Coupon[].class);
        setElementReturn(Coupon.builder().build());
        setArrayReturn(new Coupon[]{});
    }

    @Override
    @Cacheable("coupons")
    public List<Coupon> getCoupons() {
        return Arrays.asList(getObjects(getContainerConfiguration().getCouponsUrl()));
    }
}
