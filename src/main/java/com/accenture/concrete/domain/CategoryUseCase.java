package com.accenture.concrete.domain;

import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.accenture.concrete.response.CategoryResponse;

public class CategoryUseCase {

	private static final Logger LOG = LogManager.getLogger(CategoryUseCase.class);
	
	private final int TOP_QUANTITY = 5;

	private CategoryAPI api;
	
	public CategoryUseCase(CategoryAPI api) {
		this.api = api;
	}
	
	public List<CategoryResponse> getTop5Categories(){
		
		CategoryResponse response = api.findAll();
		
		List<CategoryResponse> topCategories = response.getCategories()
				.stream()
				.filter(category -> category.getId().equalsIgnoreCase("mob"))
				.flatMap(category -> category.getCategories().stream())
				.sorted(Comparator.comparingInt(CategoryResponse::getRelevance).reversed())
				.limit(TOP_QUANTITY)
				.toList();
		
		if(LOG.isDebugEnabled()) {
			LOG.debug(topCategories);
		}
		
		return topCategories;
	}
	
	public List<CategoryResponse> getRemainingCategories(){
		
		CategoryResponse response = api.findAll();
		
		List<CategoryResponse> topCategories = response.getCategories()
				.stream()
				.filter(category -> category.getId().equalsIgnoreCase("mob"))
				.flatMap(category -> category.getCategories().stream())
				.sorted(Comparator.comparingInt(CategoryResponse::getRelevance).reversed())
				.skip(TOP_QUANTITY)
				.toList();
		
		if(LOG.isDebugEnabled()) {
			LOG.debug(topCategories);
		}
		
		return topCategories;
	}
	
}
