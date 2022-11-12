package com.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.dto.CategoriesDto;

@Service
public interface CategoriesService {

	CategoriesDto getAll();

	List<CategoriesDto> getTopFive();

	List<CategoriesDto> getExceptTopFive();

}
