package com.example.demo.feign;

import com.example.demo.dto.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "indicatorClient", url = "${demo.feign.externalServer.url}")
public interface CategoryFeignClient {

    @GetMapping("/categories")
    ResponseDTO getAll();


}