package com.accenture.test.matias.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.accenture.test.matias.client.CategoryClient;
import com.accenture.test.matias.dto.CategoriesDTO;
import com.accenture.test.matias.exception.BadRequestException;
import com.accenture.test.matias.model.Category;
import com.accenture.test.matias.util.FileUtils;

public class CategoryServiceImplTest {

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Mock
    private CategoryClient categoryClient;

    @BeforeEach
    public void init() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getTopRelevanceCategories() {

        ResponseEntity<Category> categoriesResponseEntity =
                new ResponseEntity<Category>(getCategoriesMock(), HttpStatus.OK);
        int quantity = 2;

        Mockito.when(categoryClient.getCategories()).thenReturn(categoriesResponseEntity);

        CategoriesDTO result = categoryService.getTopRelevanceCategories(quantity);

        assertEquals(result.getTopCategories().size(), quantity);
    }

    @Test
    public void getTopRelevanceCategoriesBadRequest() {

        int quantity = -3;
        assertThrows(BadRequestException.class, () -> categoryService.doRequestValidations(quantity));
    }

    private Category getCategoriesMock() {

        return FileUtils.readJson("categoriesFile1.json", Category.class);
    }

}
