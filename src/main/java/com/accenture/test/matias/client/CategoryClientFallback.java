package com.accenture.test.matias.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.accenture.test.matias.model.Category;

@Component
public class CategoryClientFallback implements CategoryClient {

	@Override
	public ResponseEntity<Category> getCategories() {
		// TODO Auto-generated method stub
		return null;
	}

}
