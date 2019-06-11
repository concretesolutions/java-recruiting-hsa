package com.concrete.desafio.categories;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

  ResponseEntity<List<CategoryResponse>> topFiveCategories();

  ResponseEntity<List<CategoryResponse>> remainingCategories();
}
