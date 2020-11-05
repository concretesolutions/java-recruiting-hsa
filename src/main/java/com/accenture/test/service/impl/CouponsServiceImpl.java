package com.accenture.test.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.test.dto.Coupons;
import com.accenture.test.exceptions.ResourceNotFoundException;
import com.accenture.test.feign.CouponsFeignClient;
import com.accenture.test.service.CouponsService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CouponsServiceImpl implements CouponsService {

	@Autowired
	private CouponsFeignClient couponsClient;

	public List<Coupons> getCouponsNotExpired() {
		
		List<Coupons> response = new ArrayList<Coupons>();
		try {
			log.info("getCouponsNotExpired(");
			response = couponsClient.getCoupons();
			response = response.stream().filter(p -> p.getExpiresAt().isAfter(LocalDate.now())).collect(Collectors.toList());
		} catch (Exception e) {
			throw new ResourceNotFoundException("Not found coupons" +e);
		}

		return response;
	}

}
