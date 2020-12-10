package com.accenture.jnavarrete.controllers;

import com.accenture.jnavarrete.model.CategoriesModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpHeaders;

@RestController
public class CategoriesController {

    @GetMapping("/categories")
    public CategoriesModel getAllCategories() {
        return new CategoriesModel();
    }

    @GetMapping("/top-five-categories")
    public CategoriesModel getTopFiveCategories() {
        return new CategoriesModel();
    }
}
