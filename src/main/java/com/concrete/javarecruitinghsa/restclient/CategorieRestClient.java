package com.concrete.javarecruitinghsa.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.concrete.javarecruitinghsa.dto.categorie.CategorieLevelZero;

@FeignClient(name = "CATEGORIE", url = "${desafio.url-api-categorie}")
public interface CategorieRestClient {
	
	@GetMapping("/categories")
	public CategorieLevelZero getCategories();
	
}
