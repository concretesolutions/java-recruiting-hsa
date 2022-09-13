package com.accenture.concrete.entrypoints.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.concrete.domain.Coupon;
import com.accenture.concrete.domain.CouponAPI;
import com.accenture.concrete.domain.CouponUseCase;
import com.accenture.concrete.response.CategoryResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("coupons")
public class CouponREST {
	
	private static final Logger LOG = LogManager.getLogger(CouponREST.class);
	
	private CouponUseCase useCase;
	
	public CouponREST(CouponAPI couponApi) {
		this.useCase = new CouponUseCase(couponApi);
	}
	
	@ApiOperation(
			response = Coupon[].class,
			value = "not expired coupons",
			notes = "this api will return the response from other service, and then will return only not expired coupons."
			)
	@GetMapping(path="unexpired", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Coupon>> getNotExpiredCoupons(){
		LOG.info("finding all not expired coupons");
		return ResponseEntity.ok(useCase.getNotExpiredCoupons());
	}
	
}