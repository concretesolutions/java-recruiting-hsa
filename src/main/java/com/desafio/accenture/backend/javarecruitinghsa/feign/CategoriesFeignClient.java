package com.desafio.accenture.backend.javarecruitinghsa.feign;


import com.desafio.accenture.backend.javarecruitinghsa.dto.CategoriesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="Categories", url="${api.url.categories}")
public interface CategoriesFeignClient {

    @GetMapping(value = "/categories",
                produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<CategoriesDTO> getCategories();
}
