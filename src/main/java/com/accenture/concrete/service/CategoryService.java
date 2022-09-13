package com.accenture.concrete.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.concrete.domain.CategoryAPI;
import com.accenture.concrete.properties.CategoryProperties;
import com.accenture.concrete.response.CategoryResponse;

@Service
public class CategoryService implements CategoryAPI {
	
	private static final Logger LOG = LogManager.getLogger(CategoryService.class);

	private CategoryProperties properties;
	
	private RestTemplate restTemplate;
	
	@Autowired
	public CategoryService(CategoryProperties properties) {
		this.properties = properties;
		this.restTemplate = new RestTemplate();
	}
	
	@CachePut(value="categories")
	public CategoryResponse findAll(){
		
		CategoryResponse response = restTemplate
				.getForEntity(properties.getUriCategories(), CategoryResponse.class)
				.getBody();
		
		if(LOG.isDebugEnabled()) {
			LOG.debug(response);
		}
		
		return response;
		
	}
	
}
