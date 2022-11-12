package com.ecommerce.service.impl;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.CategoriesDto;
import com.ecommerce.feign.CategoriesClient;
import com.ecommerce.service.CategoriesService;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	private CategoriesClient client;

	@Override
	public CategoriesDto getAll() {
		return client.getAll();
	}

	@Override
	public List<CategoriesDto> getTopFive() {

		CategoriesDto dto = this.getAll();

		return dto.getSubcategories().stream().map(CategoriesDto::getSubcategories).flatMap(Collection::stream)
				.sorted(Comparator.comparing(CategoriesDto::getRelevance).reversed()).limit(5)
				.collect(Collectors.toList());
	}

	@Override
	public List<CategoriesDto>  getExceptTopFive(){
		
		CategoriesDto dto = this.getAll();

		return dto.getSubcategories().stream().map(CategoriesDto::getSubcategories).flatMap(Collection::stream)
				.sorted(Comparator.comparing(CategoriesDto::getRelevance).reversed()).skip(5)
				.collect(Collectors.toList());
		
	}
	
}
