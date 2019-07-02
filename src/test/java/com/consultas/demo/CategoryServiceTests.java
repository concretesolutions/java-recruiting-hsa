package com.consultas.demo;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.consultas.demo.dto.CategoryResponse;
import com.consultas.demo.dto.Subcategory;
import com.consultas.demo.service.CategoryService;
import com.consultas.demo.service.CategorieSeviceImpl;
import com.consultas.demo.service.CategoryServiceRestClient;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTests {
	
    @Mock
    private CategoryServiceRestClient categoryServiceRestClient;
	private CategoryService categoryService;
	
    @Before
    public void setup() {
    	categoryService = new CategorieSeviceImpl(categoryServiceRestClient);
    }
	
	@Test
	public void getCategorieTop5Test() {
		
		CategoryResponse categoryResponse = new CategoryResponse();
		categoryResponse.setId("11");
		List<Subcategory> subcategoriesList = new ArrayList<Subcategory>();
		categoryResponse.setSubcategories(subcategoriesList);
		Subcategory subcategoryOne = new Subcategory();
		subcategoryOne.setId("one");
		subcategoriesList.add(subcategoryOne);
		Subcategory subcategorTwo = new Subcategory();
		subcategorTwo.setId("two");
		subcategoriesList.add(subcategorTwo);
		
		when(categoryServiceRestClient.getCategories()).thenReturn(categoryResponse);
		CategoryResponse category = categoryService.getTopCategories();
		assertTrue(!category.getSubcategories().isEmpty());
	}
	
	@Test
	public void getCategoriesRestantesTest() {
		
		CategoryResponse categoryResponse = new CategoryResponse();
		categoryResponse.setId("22");
		List<Subcategory> subcategoriesList = new ArrayList<Subcategory>();
		categoryResponse.setSubcategories(subcategoriesList);
		Subcategory subcategoryOne = new Subcategory();
		subcategoryOne.setId("one");
		subcategoriesList.add(subcategoryOne);
		Subcategory subcategorTwo = new Subcategory();
		subcategorTwo.setId("two");
		subcategoriesList.add(subcategorTwo);
		
		when(categoryServiceRestClient.getCategories()).thenReturn(categoryResponse);
		CategoryResponse category = categoryService.getRemainingCategories();
		assertTrue(!category.getSubcategories().isEmpty());
	}

}
