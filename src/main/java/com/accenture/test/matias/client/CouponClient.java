package com.accenture.test.matias.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.accenture.test.matias.model.Coupon;

/**
 * Client for the Coupons API.
 * 
 * @author Matias Gomez Arancibia.
 *
 */
@FeignClient(name = "coupon-service", url = "https://cs-hsa-api-coupons.herokuapp.com",
        fallback = CouponClientFallback.class)
public interface CouponClient {

    /**
     * Method that gets the coupons from the api..
     * 
     * @return Categories.
     */
    @GetMapping("/coupons")
    public ResponseEntity<List<Coupon>> getCoupons();

}
