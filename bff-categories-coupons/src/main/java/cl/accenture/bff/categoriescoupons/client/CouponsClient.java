package cl.accenture.bff.categoriescoupons.client;

import cl.accenture.bff.categoriescoupons.config.FeignConfig;
import cl.accenture.bff.categoriescoupons.dto.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/*
 * Copyright (c) 2023 Boris Molina
 */
@FeignClient(name = "couponsClient", url = "${external.services.coupons.url}", configuration = FeignConfig.class)
public interface CouponsClient {

    @GetMapping("/coupons")
    List<Coupon> getCoupons();

}
