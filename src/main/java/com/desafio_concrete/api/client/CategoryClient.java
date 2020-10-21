package com.desafio_concrete.api.client;

import java.util.Collections;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.desafio_concrete.api.dto.Category;

@FeignClient(url="https://cs-hsa-api-categories.herokuapp.com", name="CATEGORIES")
public interface CategoryClient {

	@GetMapping("/categories")
	public List<Category> getCategories();
}
