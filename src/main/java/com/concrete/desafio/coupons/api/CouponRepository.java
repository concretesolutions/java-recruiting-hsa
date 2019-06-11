package com.concrete.desafio.coupons.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(url = "https://cs-hsa-api-coupons.herokuapp.com/coupons", name = "coupons")
public interface CouponRepository {

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<Coupon>> fetchCoupons();
}
