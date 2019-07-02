package com.consultas.demo.service;

import com.consultas.demo.dto.CategoryResponse;

public interface CategoryService {
		
	CategoryResponse getTopCategories();
	
	CategoryResponse getRemainingCategories();

}
