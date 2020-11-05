package com.accenture.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.test.dto.Category;
import com.accenture.test.service.CategoryService;

@RestController
@Validated
@RequestMapping(value ="/categories")
public class CategoriesController {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping(value = "/getTopFive")
	public ResponseEntity<List<Category>> getTopFive(){
		List<Category> response = service.getTopFive();
		return new ResponseEntity<List<Category>>(response,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getRemainingCategories")
	public ResponseEntity<List<Category>> getRemainingCategories(){
		List<Category> response = service.getRemainingCategories();
		return new ResponseEntity<List<Category>>(response,HttpStatus.OK);
	}

}
