package com.accenture.concrete.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.concrete.domain.Coupon;
import com.accenture.concrete.properties.CouponProperties;
import com.accenture.concrete.response.CouponResponse;

@Service
public class CouponService implements CouponAPI {
	
	private static final Logger LOG = LogManager.getLogger(CouponService.class);

	private CouponProperties properties;
	
	private RestTemplate restTemplate;
	
	@Autowired
	public CouponService(CouponProperties properties) {
		this.properties = properties;
		this.restTemplate = new RestTemplate();
	}
	
	@CachePut(value="coupons")
	public List<Coupon> findAll(){
		
		CouponResponse[] response = restTemplate
				.getForEntity(properties.getUriCoupons(), CouponResponse[].class)
				.getBody();
		
		if(LOG.isDebugEnabled()) {
			LOG.debug(response);
		}
		
		return List.of(response)
				.stream()
				.map(Coupon::new)
				.toList();
		
	}
	
}
