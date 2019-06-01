package com.concrete.challenge.controllers.web;

import com.concrete.challenge.controllers.CategoriesController;
import com.concrete.challenge.service.CategoriesService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CategoriesControllerTest {

    @InjectMocks
    private CategoriesController categoriesController;

    @Mock
    private CategoriesService categoriesService;
}
