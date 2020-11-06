package com.accenture.test.matias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.test.matias.client.CategoryClient;
import com.accenture.test.matias.model.Category;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryClient categoryClient;

	@Override
	public List<Category> getTopCategories(int quantity) {

		log.debug("[CategoryService][getTopCategories][{}] Inicio.", quantity);
		
		List<Category> result = null;
		Category category = categoryClient.getCategories().getBody();
		if(category != null && !category.getSubcategories().isEmpty()) {
			result = getTopCategories(category.getSubcategories(), quantity);
		}
		
		log.debug("[CategoryService][getTopCategories][{}] Fin.", quantity);

		return result;
	}
	
	private List<Category> getTopCategories(List<Category> category, int quantity) {
		
		
		
		return null;
	} 

}
