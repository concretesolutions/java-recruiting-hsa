package com.desafio.concrete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.concrete.model.CategoryResponse;
import com.desafio.concrete.service.CategoryService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categorieService;
	
	@ApiOperation(value = "Obtiene las categorias top5", response = CategoryResponse.class)
	@GetMapping(value = "/getCategoriesTop5")
    public CategoryResponse getCategoriesTop5() {
		
        return categorieService.getTopCategories();
    }
	
	@ApiOperation(value = "Obtiene otras categorias", response = CategoryResponse.class)
	@GetMapping(value = "/getRemainingCategories")
    public CategoryResponse getRemainingCategories() {

		
        return categorieService.getRemainingCategories();
    }
}
