package com.accenture.test.matias.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.accenture.test.matias.configuration.FeignConfiguration;
import com.accenture.test.matias.model.Category;

@FeignClient(name = "category-service", url = "https://cs-hsa-api-categories.herokuapp.com", fallback = CategoryClientFallback.class, configuration = FeignConfiguration.class)
public interface CategoryClient {

	@GetMapping("/categories")
	public ResponseEntity<Category> getCategories();
	
}
