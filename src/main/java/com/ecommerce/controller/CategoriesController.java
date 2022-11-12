package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.dto.CategoriesDto;
import com.ecommerce.service.CategoriesService;
import com.ecommerce.utils.ConstantesUtils;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class CategoriesController {

	@Autowired
	private CategoriesService service;

	@GetMapping("categories/top")
	@Operation(summary = "Get top 5 categories")
	public ResponseEntity<List<CategoriesDto>> getTopFive() {
		try {
			List<CategoriesDto> topFiveCategories = service.getTopFive();
			return ResponseEntity.status(HttpStatus.OK).body(topFiveCategories);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					ConstantesUtils.ERROR_OBTENER_TOP_CATEGORIAS, e);
		}
	}
	
	@GetMapping("categories/notop")
	@Operation(summary = "Get categories except top 5")
	public ResponseEntity<List<CategoriesDto>> getExceptTopFive() {
		try {
			List<CategoriesDto> topFiveCategories = service.getExceptTopFive();
			return ResponseEntity.status(HttpStatus.OK).body(topFiveCategories);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					ConstantesUtils.ERROR_OBTENER_TOP_CATEGORIAS, e);
		}
	}

}
