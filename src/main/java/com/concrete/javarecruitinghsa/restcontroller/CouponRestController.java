package com.concrete.javarecruitinghsa.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.concrete.javarecruitinghsa.dto.coupon.Coupon;
import com.concrete.javarecruitinghsa.service.CouponService;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.bulkhead.annotation.Bulkhead.Type;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CouponRestController {
	
	private static final String COUPUNTIMELIMITERSERV = "coupunTimeLimiterServ";
	private static final String COUPUNBULKHEADSERV = "coupunBulkHeadServ";
	private List<Coupon> couponsCache = new ArrayList<>();
	
	@Autowired
	private CouponService couponService;
	
	@ApiOperation(value = "Obtiene carrusel de cupones", response = Coupon.class )
	@ApiResponses({
		@ApiResponse(code = 200, message = "registro encontrado", response = Coupon.class)
	   ,@ApiResponse(code = 404, message = "registro no encontrado")
	})
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/v1/coupon/carrousel")
	@TimeLimiter(name=COUPUNTIMELIMITERSERV, fallbackMethod = "timeOutGetCoupons")
	@Bulkhead(name=COUPUNBULKHEADSERV, fallbackMethod = "timeOutGetCoupons", type = Type.THREADPOOL)
	public CompletableFuture<ResponseEntity<?>> carrousel(){
		List<Coupon> coupons = couponService.getUnExpiredCoupon();
		couponsCache = coupons;
		return buildResponse(couponsCache);
	}
	
	public CompletableFuture<ResponseEntity<?>>timeOutGetCoupons(Exception e){
		return buildResponse(couponsCache);
	}

	public CompletableFuture<ResponseEntity<?>> buildResponse(List<Coupon> coupons) {
		if(!coupons.isEmpty()) {
			return CompletableFuture.completedFuture(ResponseEntity.ok(coupons));	
		}else {
			return CompletableFuture.completedFuture(ResponseEntity.notFound().build());
		}
	}
}
