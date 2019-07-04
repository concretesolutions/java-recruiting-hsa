package com.desafio.concrete.service;

import com.desafio.concrete.model.CategoryResponse;

public interface CategoryService {
		
	CategoryResponse getTopCategories();
	
	CategoryResponse getRemainingCategories();

}
