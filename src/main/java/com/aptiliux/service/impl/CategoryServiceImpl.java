package com.aptiliux.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aptiliux.dto.category.Category;
import com.aptiliux.dto.category.CategoryDTO;
import com.aptiliux.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Value("${ws.legacy.categories.endpoint}")
    private String endpoint;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Optional<CategoryDTO> getAllCategories() {
        ResponseEntity<CategoryDTO> response = restTemplate.exchange(endpoint, HttpMethod.GET, null,
                CategoryDTO.class);
        return Optional.ofNullable(response)
        		.map(ResponseEntity::getBody);
    }

    @Override
    public List<Category> getTopCategories(Long offset,Long limit) {
    	
    	Optional<CategoryDTO> categories = getAllCategories();
    	return categories.map(x -> x.flattened())
    			.map(s -> s.filter(y -> Objects.nonNull(y.getRelevance()))
    					   .sorted((a,b)-> b.getRelevance().compareTo(a.getRelevance()))
    					   .skip(defaultValue(offset,0L))
    					   .limit(defaultValue(limit,Long.MAX_VALUE))
    					)
    			.map(s -> s.collect(Collectors.toList()))
    			.orElse(new ArrayList<>());  
    }

    private Long defaultValue(Long input, Long defaultValue) {
    	return Optional
    			.ofNullable(input)
    			.map(Math::abs)
    			.orElse(defaultValue);
    }
}
