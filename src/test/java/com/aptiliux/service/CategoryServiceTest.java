package com.aptiliux.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.aptiliux.dto.category.Category;
import com.aptiliux.dto.category.CategoryDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryServiceTest {

	@Autowired
	private CategoryService categoryService;
	
	@MockBean
    private RestTemplate restTemplate;
	
	private CategoryDTO category;
	
	@Before
    public void InitialData() {
		this.category = loadJson("src/test/resources/categories.json", CategoryDTO.class);
		
		when(restTemplate.exchange(
				any(String.class), 
				eq(HttpMethod.GET),
				eq(null),
				eq(CategoryDTO.class)))
		.thenReturn(new ResponseEntity<CategoryDTO>(category, HttpStatus.OK));
	}
	
	
	@Test
	public void shoulReturnAllCategoriesWithRelevance() {
		List<Category> categories = categoryService.getTopCategories(null, null);
		assertEquals(13,categories.size());
	}
	
	
	@Test
	public void shoulReturnTopCategoriesWithRelevance() {
		List<Category> categories = categoryService.getTopCategories(null, 5L);
		assertEquals(5,categories.size());
		assertEquals(700,categories.get(0).getRelevance().intValue());
		assertEquals(150,categories.get(categories.size()-1).getRelevance().intValue());
	}
	
	@Test
	public void shoulReturnTailCategoriesWithRelevance() {		
		List<Category> categories = categoryService.getTopCategories(5L, null);
		assertEquals(8,categories.size());
		assertEquals(100,categories.get(0).getRelevance().intValue());
		assertEquals(1,categories.get(categories.size()-1).getRelevance().intValue());
	}
	
	
    private <T> T loadJson(final String path, Class<T> clazz) {
        File jFile = new File(path);

        ObjectMapper jObject = new ObjectMapper();
        try {
            return jObject.readValue(jFile, clazz);
        } catch (IOException e) {
            return null;
        }
    }

}
