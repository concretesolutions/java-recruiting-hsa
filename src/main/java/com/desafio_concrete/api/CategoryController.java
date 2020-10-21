package com.desafio_concrete.api;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.desafio_concrete.api.client.CategoryClient;
import com.desafio_concrete.api.dto.Category;
import com.desafio_concrete.api.dto.CategoryTree;


@RestController
public class CategoryController {

	@Autowired
	private CategoryClient clientCategory;
	
	@Async
	@GetMapping("/categories")
	public List<Category> getCategories() {
		return clientCategory.getCategories();
	}
}
