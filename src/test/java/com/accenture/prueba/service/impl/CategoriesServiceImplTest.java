package com.accenture.prueba.service.impl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

class CategoriesServiceImplTest {

    @InjectMocks
    private CategoriesServiceImplTest categoriesServiceImplTest;

    @Test
    void getAll() {
        categoriesServiceImplTest.getAll();
    }

    @Test
    void getTop() {
        categoriesServiceImplTest.getTop();
    }

    @Test
    void getAnother() {
        categoriesServiceImplTest.getAnother();
    }
}