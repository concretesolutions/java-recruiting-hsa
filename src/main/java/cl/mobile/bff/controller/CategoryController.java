package cl.mobile.bff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.mobile.bff.domain.CategoryClientResponse;
import cl.mobile.bff.service.interfaces.CategoryService;

@RestController
@RequestMapping(value = "/bff/mobile/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = "/topfive")
	public List<CategoryClientResponse> getTopFive() {
		return categoryService.getTopFive();	
	}
	
	@GetMapping(value = "/remain")
	public List<CategoryClientResponse> getRemainCategory() {
		return categoryService.getRemain();
	}
}