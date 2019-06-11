package com.concrete.desafio.categories.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "https://cs-hsa-api-categories.herokuapp.com/categories", name = "categories")
public interface CategoryRepository {

  @RequestMapping(method = RequestMethod.GET)
  ResponseEntity<CategoryThree> fetchCategoryThree();
}
