package com.consultas.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.consultas.demo.dto.CategoryResponse;

@FeignClient(url="https://cs-hsa-api-categories.herokuapp.com",name="CATEGORY")
public interface CategoryServiceRestClient {
 
	@GetMapping("/categories")
	public CategoryResponse getCategories();
	
}
