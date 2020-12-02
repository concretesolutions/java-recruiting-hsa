package com.accenture.pruebamanuel.service;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.accenture.pruebamanuel.client.CategoryClient;

public class CategoryServiceTest {

	@InjectMocks
	private CategoryService categoryService;

	@Mock
	private CategoryClient categoryClient;

	@BeforeEach
	public void init() {

		MockitoAnnotations.initMocks(this);
	}
//
//	TODO: pendiente de finalizacion de Junit para service de CategoryService.
//	@Test
//	public void getTopCategories() {
//
//		Categoria categorias = PruebaUtil.readJson("apiCategory.json", Categoria.class);
//
//		ResponseEntity<Categoria> categoriesResponseEntity = new ResponseEntity<Categoria>(categorias, HttpStatus.OK);
//
//		Mockito.when(categoryClient.getAllCategories()).thenReturn(categoriesResponseEntity);
//
//		Categorias result = categoryService.getAllCategories();
//
//		assertEquals(result.getTop5Categoria().size(), 5);
//	}
}
