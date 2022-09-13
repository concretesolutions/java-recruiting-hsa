package com.accenture.concrete.domain;

import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.accenture.concrete.response.CategoryResponse;

public class CategoryUseCase {

	private static final Logger LOG = LogManager.getLogger(CategoryUseCase.class);
	
	private CategoryAPI api;
	
	public CategoryUseCase(CategoryAPI api) {
		this.api = api;
	}
	
	public List<CategoryResponse> getTopCategories(int quantity){
		
		CategoryResponse response = api.findAll();
		
		List<CategoryResponse> topCategories = response.getCategories()
				.stream()
				.filter(category -> category.getId().equalsIgnoreCase("mob"))
				.flatMap(category -> category.getCategories().stream())
				.sorted(Comparator.comparingInt(CategoryResponse::getRelevance).reversed())
				.limit(quantity)
				.toList();
		
		if(LOG.isDebugEnabled()) {
			LOG.debug(topCategories);
		}
		
		return topCategories;
	}
	
}
