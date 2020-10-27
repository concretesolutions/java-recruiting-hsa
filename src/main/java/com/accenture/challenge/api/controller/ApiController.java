package com.accenture.challenge.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.challenge.api.dto.CategoryDTO;
import com.accenture.challenge.api.exceptions.CustomNotFoundException;
import com.accenture.challenge.api.exceptions.ProxyException;
import com.accenture.challenge.api.models.Coupon;
import com.accenture.challenge.api.proxy.ProxyService;
import com.accenture.challenge.api.rs.CategoryResponse;
import com.accenture.challenge.api.rs.CouponResponse;
import com.accenture.challenge.api.rs.Status;
import com.accenture.challenge.api.utils.Constant;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private ProxyService service;


	@ApiOperation(value = "Return the first top number of categories. Optional: Image Type: all, large, medium, small")
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = Constant.SUCCESSFUL),
					@ApiResponse(code = 404, message = Constant.NOT_FOUND)
					}
			)
	@GetMapping(path = "/categories/top/{top}", produces = "application/json")
	public ResponseEntity<CategoryResponse> getTopCategories(@PathVariable int top, @RequestParam (required = false, defaultValue = "all") String imageType  ) throws ProxyException, CustomNotFoundException {
		
		CategoryResponse response = getTopCategoryResponse(top, imageType);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private CategoryResponse getTopCategoryResponse(int top, String imageType) throws ProxyException, CustomNotFoundException {
		List<CategoryDTO> categoryDTOs = this.service.getTopCategories(top, imageType);		
		CategoryResponse response = new CategoryResponse();
			Status status = new Status();
				status.setCode(HttpStatus.OK.value());
				status.setMessage(Constant.SUCCESSFUL);
			response.setServiceStatus(status);
			response.setCategories(categoryDTOs);
			response.setStatus(HttpStatus.OK.toString());
		return response;
	}
	
	@ApiOperation(value = "Return the remainder categories (after top). Optional: Image Type: all, large, medium, small")
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = Constant.SUCCESSFUL),
					@ApiResponse(code = 404, message = Constant.NOT_FOUND)
					}
			)
	@GetMapping(path = "/categories/after/{top}/remainder/{imageType}", produces = "application/json")
	public ResponseEntity<CategoryResponse> getCategories(@PathVariable int top, @RequestParam (required = false, defaultValue = "small") String imageType) throws ProxyException, CustomNotFoundException {
		CategoryResponse response = getCategoryRemainderResponse(top, imageType);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private CategoryResponse getCategoryRemainderResponse(int top, String imageType) throws ProxyException, CustomNotFoundException {
		List<CategoryDTO> categoryRemainderDTOs = this.service.getCategoriesRemainder(top, imageType);
		CategoryResponse response = new CategoryResponse();
			Status status = new Status();
				status.setCode(HttpStatus.OK.value());
				status.setMessage(Constant.SUCCESSFUL);
			response.setServiceStatus(status);
			response.setCategoriesRemaider(categoryRemainderDTOs);
			response.setStatus(HttpStatus.OK.toString());
		return response;
	}
	
	
	@ApiOperation(value = "Return coupons expired or not experired (expired = true or expired = false)")
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = Constant.SUCCESSFUL),
					@ApiResponse(code = 404, message = Constant.NOT_FOUND)
					}
			)
	@GetMapping(path = "/coupons/expired/{expired}", produces = "application/json")
	public ResponseEntity<CouponResponse> getCoupons(@PathVariable(value = "expired") boolean expired) throws ProxyException, CustomNotFoundException {
		
		CouponResponse response = getCouponResponse(expired);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	private CouponResponse getCouponResponse(boolean expired) throws ProxyException, CustomNotFoundException {
		
		List<Coupon> coupons = this.service.getCoupons(expired);
			CouponResponse response = new CouponResponse();
			Status status = new Status();
				status.setCode(HttpStatus.OK.value());
				status.setMessage(Constant.SUCCESSFUL);
			response.setServiceStatus(status);
			response.setCoupons(coupons);
			response.setStatus(HttpStatus.OK.toString());
		return response;
	}
}
