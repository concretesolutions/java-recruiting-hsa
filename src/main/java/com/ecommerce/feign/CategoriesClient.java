package com.ecommerce.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecommerce.dto.CategoriesDto;
import com.ecommerce.feign.fallback.CategoriesClientFallback;

import feign.Headers;

@FeignClient(name = "${categories.api.name}", url = "${categories.api.url}", fallback = CategoriesClientFallback.class)
@Headers("accept: application/json")
public interface CategoriesClient {

	@GetMapping("/categories")
    CategoriesDto getAll();

}
