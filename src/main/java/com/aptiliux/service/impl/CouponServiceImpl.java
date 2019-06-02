package com.aptiliux.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aptiliux.dto.coupon.CouponDTO;
import com.aptiliux.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService {

    @Value("${ws.legacy.coupons.endpoint}")
    private String endpoint;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public List<CouponDTO> getAllCoupons() {
        ResponseEntity<List<CouponDTO>> response = restTemplate.exchange(endpoint, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<CouponDTO>>() {});
        return Optional.ofNullable(response)
        		.map(ResponseEntity::getBody)
        		.orElse(new ArrayList<CouponDTO>());
    }
    
    @Override
    public List<CouponDTO> getNonExpiredCoupons() {
    	Date currentDate =  new Date();
    	List<CouponDTO> allCoupons = getAllCoupons();
    	return Optional
    			.ofNullable(allCoupons)
    			.map(List<CouponDTO>::stream)
    			.map(coupons -> coupons.filter(c -> c.getExpiresAt().after(currentDate))
    					.collect(Collectors.toList()))
    			.orElse(new ArrayList<CouponDTO>());

    }
}
