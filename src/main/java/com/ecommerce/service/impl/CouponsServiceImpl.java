package com.ecommerce.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.CouponsDto;
import com.ecommerce.feign.CouponsClient;
import com.ecommerce.service.CouponsService;

@Service
public class CouponsServiceImpl implements CouponsService {
	
	@Autowired
	private CouponsClient client;

	@Override
	public List<CouponsDto> getCouponsNotExpired() {		
		
		List<CouponsDto> list = client.getAll().stream()
			    .filter(n -> LocalDate.parse(n.getExpiresAt()).isAfter(LocalDate.now()))
			    .collect(Collectors.toList());
		
		return list;
	}
	
	 

}
