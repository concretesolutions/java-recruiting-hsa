package com.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.dto.CouponsDto;

@Service
public interface CouponsService {
	
	List<CouponsDto> getCouponsNotExpired();

}
