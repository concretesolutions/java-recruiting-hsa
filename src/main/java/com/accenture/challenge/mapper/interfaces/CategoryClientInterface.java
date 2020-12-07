package com.accenture.challenge.mapper.interfaces;

import java.util.List;
 
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.accenture.challenge.mapper.models.Coupon;

@FeignClient(name="coupens-consumer", url="https://cs-hsa-api-coupons.herokuapp.com")
public interface CategoryClientInterface {

    @GetMapping(value = "/categories")
    List<Coupon> consumerService();
    
}


