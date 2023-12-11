package cl.accenture.bff.categoriescoupons.controller;

import cl.accenture.bff.categoriescoupons.dto.Category;
import cl.accenture.bff.categoriescoupons.service.CategoriesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

/*
 * Copyright (c) 2023 Boris Molina
 */
@ExtendWith(MockitoExtension.class)
public class CategoriesControllerTest {

    @Mock
    private CategoriesService categoriesService;

    @InjectMocks
    private CategoriesController categoriesController;

    @Test
    public void testGetCategories() {
        when(categoriesService.getCategories())
                .thenReturn(Category.builder().build());

        final ResponseEntity<Category> result = categoriesController.getCategories();

        Assertions.assertNotNull(result);
    }

    @Test
    public void testTop5GetCategories() {
        when(categoriesService.getTop5Categories())
                .thenReturn(Collections.singletonList(Category.builder().build()));

        final ResponseEntity<List<Category>> result = categoriesController.getTop5Categories();

        Assertions.assertNotNull(result);
    }

}
