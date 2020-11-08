package com.accenture.test.matias.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.accenture.test.matias.exception.BadRequestException;
import com.accenture.test.matias.service.CategoryService;

public class CategoryControllerTest {

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryService categoryService;

    @BeforeEach
    public void init() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getTopRelevanceCategoriesBadRequest() {

        int quantity = -3;
        Mockito.when(categoryController.getTopRelevanceCategories(quantity)).thenThrow(BadRequestException.class);
        assertThrows(BadRequestException.class, () -> categoryController.getTopRelevanceCategories(quantity));
    }
}
