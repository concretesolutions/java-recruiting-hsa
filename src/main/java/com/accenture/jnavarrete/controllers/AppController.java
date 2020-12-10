package com.accenture.jnavarrete.controllers;

import com.accenture.jnavarrete.model.CategoriesModel;
import com.accenture.jnavarrete.services.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AppController {

    private final CategoriesService categoriesService;

    @GetMapping("/categories")
    public CategoriesModel getData() {
        return categoriesService.getAllCategories();
    }
}