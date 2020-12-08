package com.accenture.challenge.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CategoryControllerTest {

    private CategoryController categoryController;

    @Before
    public void init(){
        categoryController = new CategoryController();
    }
    @Test
    public void sampleControllerShouldCallService() {

        String response1 = categoryController.getcategoriesList();
        String response2 = categoryController.getcategoriesList();
        
        assertTrue(response1.equals(response2));    
    }
}
