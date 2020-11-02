package com.example.javarecruitinghsa.repository;

import com.example.javarecruitinghsa.pojo.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class CouponRepository {

    @Autowired
    RestTemplateBuilder builder;

    public Coupon[] findCouponList() {
        String url = "https://cs-hsa-api-coupons.herokuapp.com/coupons";
        Coupon[] body = builder
                .setConnectTimeout(Duration.ofSeconds(10l))
                .build()
                .getForEntity(url,
                        Coupon[].class)
                .getBody();
        return body;
    }
}
