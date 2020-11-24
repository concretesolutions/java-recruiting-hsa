package com.accenture.javarecruiting.clients;

import com.accenture.javarecruiting.dto.CouponsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "coupons-client", url = "https://cs-hsa-api-coupons.herokuapp.com")
public interface CouponsClient {

    @GetMapping("/coupons")
    List<CouponsDTO> getAll();
}
