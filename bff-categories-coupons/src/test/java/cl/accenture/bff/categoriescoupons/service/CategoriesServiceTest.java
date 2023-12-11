package cl.accenture.bff.categoriescoupons.service;

import cl.accenture.bff.categoriescoupons.client.CategoriesClient;
import cl.accenture.bff.categoriescoupons.dto.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

/*
 * Copyright (c) 2023 Boris Molina
 */
@ExtendWith(MockitoExtension.class)
public class CategoriesServiceTest {

    @Mock
    private CategoriesClient categoriesClient;

    @InjectMocks
    private CategoriesService categoriesService;

    @Test
    public void testGetCategories() {
        when(categoriesClient.getCategories())
                .thenReturn(Category.builder().build());

        final Category result = categoriesService.getCategories();

        Assertions.assertNotNull(result);
    }

    @Test
    public void testGetTop5CategoriesIsEmpty() {
        when(categoriesClient.getCategories())
                .thenReturn(Category.builder().build());

        final List<Category> result = categoriesService.getTop5Categories();

        Assertions.assertNotNull(result);
    }

    @Test
    public void testGetTop5Categories() {
        when(categoriesClient.getCategories())
                .thenReturn(buildCategory());

        final List<Category> result = categoriesService.getTop5Categories();

        Assertions.assertNotNull(result);
    }

    private Category buildCategory() {
        return Category.builder()
                .subcategories(
                        Collections.singletonList(
                                Category.builder()
                                        .subcategories(
                                              Collections.singletonList(
                                                      Category.builder()
                                                              .id("1")
                                                              .build()
                                              )
                                        )
                                        .build()
                        )
                )
                .build();
    }

}
