package com.concrete.challenge.apis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.concrete.challenge.models.CategoryResponse;

@FeignClient(url="https://cs-hsa-api-categories.herokuapp.com",name="CATEGORY")
public interface CategoryApi {
	
	@GetMapping("/categories")
	public CategoryResponse getCategories();
	
	public default String connect() {
		return "Api categories ok!";
	}
}