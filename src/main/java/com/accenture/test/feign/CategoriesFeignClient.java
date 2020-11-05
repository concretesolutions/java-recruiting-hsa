package com.accenture.test.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.accenture.test.dto.CategoryThree;

import feign.Headers;

@FeignClient(url = "${apis.service.categories}", name = "${apis.service.nameCategories}")
public interface CategoriesFeignClient {

	@GetMapping("/categories")
	@Headers("accept: application/json")
	public CategoryThree getCategories();
}
