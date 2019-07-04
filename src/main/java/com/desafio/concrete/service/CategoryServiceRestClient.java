package com.desafio.concrete.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.desafio.concrete.model.CategoryResponse;

@FeignClient(url="https://cs-hsa-api-categories.herokuapp.com",name="CATEGORY")
public interface CategoryServiceRestClient {
 
	@GetMapping("/categories")
	public CategoryResponse getCategories();
	
}
