package cl.concretesolutions.mobileapp.api.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cl.concretesolutions.mobileapp.api.category.CategoryDto;
import cl.concretesolutions.mobileapp.api.category.CategoryTree;
import cl.concretesolutions.mobileapp.api.category.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@Async
	@GetMapping("/categories")
	public List<CategoryDto> getCategories() {
		return service.getCategories();
	}
	
	@Async
	@GetMapping("/categories/top/{numCategories}")
	public List<CategoryDto> getTopNCategories(@PathVariable int numCategories) {
		return service.getTopNCategories(numCategories);
	}
	
	@Async
	@GetMapping("/categories/tree")
	public CategoryTree getCategoriesOld() {
		return service.getOriginalCategories();
	}
}
