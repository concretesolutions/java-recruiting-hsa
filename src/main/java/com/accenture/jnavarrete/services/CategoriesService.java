package com.accenture.jnavarrete.services;

import com.accenture.jnavarrete.model.CategoriesModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "categories-client", url = "https://cs-hsa-api-categories.herokuapp.com")

public interface CategoriesService {
    @GetMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoriesModel getAllCategories();
}
