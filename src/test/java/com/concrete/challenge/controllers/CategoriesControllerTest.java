package com.concrete.challenge.controllers;

import com.concrete.challenge.bean.categories.external.SubCategoryLevel2;
import com.concrete.challenge.bean.categories.structure.Category;
import com.concrete.challenge.service.CategoriesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoriesControllerTest {

    @InjectMocks
    private CategoriesController categoriesController;

    @Mock
    private CategoriesService categoriesService;

    @Test
    public void topFiveZeroCategoriesTest() {
        List<Category> categories = getZeroCategories();
        int relevantCategories = 5;

        when(categoriesService.getTopCategories(relevantCategories)).thenReturn(categories);

        ResponseEntity<List<Category>> result = categoriesController.getTopCategories(relevantCategories);
        assertEquals("The HttpStatus should be 204", HttpStatus.NO_CONTENT, result.getStatusCode());
    }

    private List<Category> getZeroCategories() {
        return new ArrayList<>();
    }

    @Test
    public void topFiveWithMoreThanOneCategoriesTest() {
        List<Category> categories = getMoreThanZeroCategories();
        int relevantCategories = 5;

        when(categoriesService.getTopCategories(relevantCategories)).thenReturn(categories);

        ResponseEntity<List<Category>> result = categoriesController.getTopCategories(relevantCategories);
        assertEquals("The HttpStatus should be 200", HttpStatus.OK, result.getStatusCode());
    }

    private List<Category> getMoreThanZeroCategories() {
        return Arrays.asList(SubCategoryLevel2.builder().build(),
                SubCategoryLevel2.builder().build());
    }

    @Test
    public void topFiveLessThanFiveCategoriesTest() {
        List<Category> categories = getLessThanFiveCategories();
        int relevantCategories = 5;

        when(categoriesService.getTopCategories(relevantCategories)).thenReturn(categories);

        ResponseEntity<List<Category>> result = categoriesController.getTopCategories(relevantCategories);
        assertEquals("The amount of results should be less than five", 4, Objects.requireNonNull(result.getBody()).size());
    }

    private List<Category> getLessThanFiveCategories() {
        return Arrays.asList(
                SubCategoryLevel2.builder().build(),
                SubCategoryLevel2.builder().build(),
                SubCategoryLevel2.builder().build(),
                SubCategoryLevel2.builder().build()
        );
    }

    @Test
    public void topFiveCategoriesTest() {
        List<Category> categories = getFiveCategories();
        int relevantCategories = 5;

        when(categoriesService.getTopCategories(relevantCategories)).thenReturn(categories);

        ResponseEntity<List<Category>> result = categoriesController.getTopCategories(relevantCategories);
        assertEquals("The amount of results should be five", 5, Objects.requireNonNull(result.getBody()).size());
    }

    private List<Category> getFiveCategories() {
        return Arrays.asList(
                SubCategoryLevel2.builder().build(),
                SubCategoryLevel2.builder().build(),
                SubCategoryLevel2.builder().build(),
                SubCategoryLevel2.builder().build(),
                SubCategoryLevel2.builder().build()
        );
    }

    @Test
    public void afterTopFiveZeroCategoriesTest() {
        List<Category> categories = getZeroCategories();
        int relevantCategories = 5;

        when(categoriesService.getTopCategoriesAfterTop(relevantCategories)).thenReturn(categories);

        ResponseEntity<List<Category>> result = categoriesController.getCategoriesAfterTop(relevantCategories);
        assertEquals("The HttpStatus should be 204", HttpStatus.NO_CONTENT, result.getStatusCode());
    }

    @Test
    public void afterTopFiveCategoriesTest() {
        List<Category> categories = getLessRelevantCategories();
        int relevantCategories = 5;

        when(categoriesService.getTopCategoriesAfterTop(relevantCategories)).thenReturn(categories);

        ResponseEntity<List<Category>> result = categoriesController.getCategoriesAfterTop(relevantCategories);
        assertEquals("The HttpStatus should be 200", HttpStatus.OK, result.getStatusCode());
    }

    private List<Category> getLessRelevantCategories() {
        return Arrays.asList(
                SubCategoryLevel2.builder().build(),
                SubCategoryLevel2.builder().build(),
                SubCategoryLevel2.builder().build()
        );
    }

}
