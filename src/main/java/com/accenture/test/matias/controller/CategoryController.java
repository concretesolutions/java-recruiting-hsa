package com.accenture.test.matias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.test.matias.model.Category;
import com.accenture.test.matias.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/top/{quantity}")
	public ResponseEntity<List<Category>> getTopCategories(@PathVariable("quantity") int quantity) {

		log.info("[CategoryController][getTopCategories] Inicio.");
		List<Category> resp = categoryService.getTopCategories(quantity);
		log.info("[CategoryController][getTopCategories] Fin.");

		return new ResponseEntity<List<Category>>(resp, HttpStatus.OK);
	}

}
