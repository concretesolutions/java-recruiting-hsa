package com.accenture.test.matias.service;

import java.util.List;

import com.accenture.test.matias.model.Category;

public interface CategoryService {
	
	public List<Category> getTopCategories(int quantity);

}
