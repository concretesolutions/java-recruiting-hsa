package com.concrete.challenge.dao;

import com.concrete.challenge.api.Endpoints;
import com.concrete.challenge.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CouponDAO {

    @Autowired
    RestTemplate restTemplate;

    @Cacheable("coupons")
    public List<Coupon> getCoupons() {

        List<Coupon> couponsList;
        try{
            Coupon[] coupons = restTemplate.getForObject(
                    Endpoints.COUPONS_ENDPOINT, Coupon[].class);
            couponsList = Arrays.asList(coupons.clone());
        }catch (RestClientException ex){
            couponsList = new ArrayList<>();
        }

        return couponsList;
    }
}
