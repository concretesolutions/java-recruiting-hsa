package com.desafio.accenture.backend.javarecruitinghsa.feign;

import com.desafio.accenture.backend.javarecruitinghsa.dto.CategoriesDTO;
import com.desafio.accenture.backend.javarecruitinghsa.dto.CouponsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="Coupons", url="${api.url.coupons}")
public interface CouponsFeignClient {

    @GetMapping("/coupons")
    ResponseEntity<List<CouponsDTO> > getCoupons();
}
