package com.concrete.categoria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.concrete.categoria.dto.SubcategoryLevel2DTO;
import com.concrete.categoria.dto.SubcategoryLevel3DTO;
import com.concrete.categoria.dto.SubcategoryLevel4DTO;
import com.concrete.categoria.service.CategoryService;
import com.concrete.categoria.service.ConsumeService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/categoria")
public class CategoryController {
	
	@Autowired
	ConsumeService consumeService;
	@Autowired
	CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET, value = "listar/todo", produces = "application/json")
	public String getAll() {

		String json = new Gson().toJson(categoryService.getCategoriesTree());
		return json;
		
	}
		
	@RequestMapping(method = RequestMethod.GET, value = "relevante/listar/top-5", produces = "application/json")
	public String getTop5() {
		
		String json = new Gson().toJson(categoryService.getTop5Categories());
		return json;

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "relevante/listar/restantes", produces = "application/json")
	public String getRemainingCategories() {

		String json = new Gson().toJson(categoryService.getRemainingCategories());
		return json;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{sub2}", produces = "application/json")
	public String getSubCategory2ListOfCategory(@PathVariable String sub2) {

		SubcategoryLevel2DTO[]  subcategoriesLevel2 = categoryService.getSubCategory2ListOfCategory(sub2);
		String json = new Gson().toJson(subcategoriesLevel2);
		return json;
		
	} 
	
	@RequestMapping(method = RequestMethod.GET, value = "{sub2}/sub-categoria/{sub3}", produces = "application/json")
	public String getSubCategory3ListOfCategory(@PathVariable String sub2,@PathVariable String sub3) {

		SubcategoryLevel3DTO[]  subcategoriesLevel3 = categoryService.getSubCategory3ListOfSubCategory2(sub2, sub3);
		String json = new Gson().toJson(subcategoriesLevel3);
		return json;
		
	} 
	
	@RequestMapping(method = RequestMethod.GET, value = "{sub2}/sub-categoria/{sub3}/sub-categoria/{sub4}", produces = "application/json")
	public String getSubCategory4ListOfCategory(@PathVariable String sub2,@PathVariable String sub3,@PathVariable String sub4) {

		SubcategoryLevel4DTO[]  subcategoriesLevel4 = categoryService.getSubCategory4ListOfSubCategory3(sub2, sub3, sub4);
		String json = new Gson().toJson(subcategoriesLevel4);
		return json;
		
	} 

}
