package com.accenture.javarecruiting.clients;

import com.accenture.javarecruiting.dto.CategoriesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "categories-client", url = "https://cs-hsa-api-categories.herokuapp.com")
public interface CategoriesClient {

    @GetMapping("/categories")
    CategoriesDTO CATEGORIES();
}
