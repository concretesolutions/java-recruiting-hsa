package com.accenture.concrete.entrypoints.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.concrete.domain.CategoryAPI;
import com.accenture.concrete.domain.CategoryUseCase;
import com.accenture.concrete.domain.Coupon;
import com.accenture.concrete.domain.CouponAPI;
import com.accenture.concrete.domain.CouponUseCase;
import com.accenture.concrete.response.CategoryResponse;

@RestController
@RequestMapping("categories")
public class CategoryREST {
	
	private static final Logger LOG = LogManager.getLogger(CategoryREST.class);
	
	private CategoryUseCase useCase;
	
	public CategoryREST(CategoryAPI couponApi) {
		this.useCase = new CategoryUseCase(couponApi);
	}
	
	@GetMapping(path="top", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoryResponse>> getTop5Categories(){
		LOG.info("obtaining top categories");
		return ResponseEntity.ok(useCase.getTop5Categories());
	}
	
	@GetMapping(path="remaining", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoryResponse>> getRemainingCategories(){
		LOG.info("obtaining top categories");
		return ResponseEntity.ok(useCase.getRemainingCategories());
	}
	
}