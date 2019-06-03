package com.concrete.challenge.service;

import com.concrete.challenge.bean.categories.external.Categories;
import com.concrete.challenge.bean.categories.external.CategoryThree;
import com.concrete.challenge.bean.categories.external.SubCategoryLevel2;
import com.concrete.challenge.bean.categories.structure.Category;
import com.concrete.challenge.client.categories.CategoriesClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoriesServiceTest {

    @InjectMocks
    private CategoriesService categoriesService;

    @Mock
    private CategoriesClient categoriesClient;

    @Test
    public void topFiveZeroCategoriesTest() {
        CategoryThree categories = getZeroCategories();
        int relevantCategories = 5;

        when(categoriesClient.getCategory()).thenReturn(categories);

        List<Category> result = categoriesService.getTopCategories(relevantCategories);
        assertEquals("The result should be zero", 0, result.size());
    }

    private CategoryThree getZeroCategories() {
        return CategoryThree.builder()
                .subcategories(Collections.singletonList(
                        Categories.builder()
                                .subcategories(new ArrayList<>())
                                .build()
                ))
                .build();
    }

    @Test
    public void topFiveLessThanFiveCategoriesTest() {
        CategoryThree categories = getLessThanFiveCategories();
        int relevantCategories = 5;

        when(categoriesClient.getCategory()).thenReturn(categories);

        List<Category> result = categoriesService.getTopCategories(relevantCategories);
        assertEquals("The result should be less than five", 4, result.size());
    }

    private CategoryThree getLessThanFiveCategories() {
        return CategoryThree.builder()
                .subcategories(Collections.singletonList(
                        Categories.builder()
                                .subcategories(Arrays.asList(
                                        SubCategoryLevel2.builder().build(),
                                        SubCategoryLevel2.builder().build(),
                                        SubCategoryLevel2.builder().build(),
                                        SubCategoryLevel2.builder().build()
                                ))
                                .build()
                ))
                .build();
    }

    @Test
    public void topFiveMoreThanFiveCategoriesTest() {
        CategoryThree categories = getMoreThanFiveCategories();
        int relevantCategories = 5;

        when(categoriesClient.getCategory()).thenReturn(categories);

        List<Category> result = categoriesService.getTopCategories(relevantCategories);
        assertEquals("The result should be five", 5, result.size());
    }

    private CategoryThree getMoreThanFiveCategories() {
        return CategoryThree.builder()
                .subcategories(Collections.singletonList(
                        Categories.builder()
                                .subcategories(Arrays.asList(
                                        SubCategoryLevel2.builder().build(),
                                        SubCategoryLevel2.builder().build(),
                                        SubCategoryLevel2.builder().build(),
                                        SubCategoryLevel2.builder().build(),
                                        SubCategoryLevel2.builder().build(),
                                        SubCategoryLevel2.builder().build()
                                ))
                                .build()
                ))
                .build();
    }

    @Test
    public void afterTopFiveZeroCategoriesTest() {
        CategoryThree categories = getZeroCategories();
        int relevantCategories = 5;

        when(categoriesClient.getCategory()).thenReturn(categories);

        List<Category> result = categoriesService.getTopCategoriesAfterTop(relevantCategories);
        assertEquals("The result should be zero", 0, result.size());
    }

    @Test
    public void afterTopFiveLessThanFiveCategoriesTest() {
        CategoryThree categories = getLessThanFiveCategories();
        int relevantCategories = 5;

        when(categoriesClient.getCategory()).thenReturn(categories);

        List<Category> result = categoriesService.getTopCategoriesAfterTop(relevantCategories);
        assertEquals("The result should be zero", 0, result.size());
    }

    @Test
    public void afterTopFiveMoreThanFiveCategoriesTest() {
        CategoryThree categories = getMoreThanFiveCategories();
        int relevantCategories = 5;

        when(categoriesClient.getCategory()).thenReturn(categories);

        List<Category> result = categoriesService.getTopCategoriesAfterTop(relevantCategories);
        assertEquals("The result should be one", 1, result.size());
    }
}
