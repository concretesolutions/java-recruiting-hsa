package com.concrete.desafio.categories.api;

import org.springframework.http.ResponseEntity;

public class CategoryApiRepository implements CategoryRepository{
    @Override
    public ResponseEntity<CategoryThree> getCategoryThree() {
        return null;
    }
}
