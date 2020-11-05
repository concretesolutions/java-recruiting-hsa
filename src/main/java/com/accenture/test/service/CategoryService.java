package com.accenture.test.service;

import java.util.List;

import com.accenture.test.dto.Category;

public interface CategoryService {
	
	List<Category> getTopFive();

	List<Category> getRemainingCategories();
}
