package com.accenture.test.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.accenture.test.dto.Category;
import com.accenture.test.service.CategoryService;

public class ControllerCategoriesTest {

	@Mock
    private CategoryService categoryService;

	@InjectMocks
    private CategoriesController categoriesController;
	    
    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getTopFive() {
    	
    	Category category = new Category();
    	category.setId("asas");
    	category.setName("prueba");
    	category.setRelevance(700);
    	category.setSmallImageUrl("url");
    	category.setIconImageUrl("url");
  
    	List<Category> list = new ArrayList<Category>();
    	list.add(category);
    	        
        Mockito.when(categoryService.getTopFive()).thenReturn(list);

        ResponseEntity<?> result = categoriesController.getTopFive();

        assertThat(result.getBody()).isNotNull();
    }
}
