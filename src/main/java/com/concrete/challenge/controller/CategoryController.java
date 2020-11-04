package com.concrete.challenge.controller;

import com.concrete.challenge.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/top")
    public List<Object> topFiveCategories(){
        return service.findTopFiveCategories();
    }

    @GetMapping
    public List<Object> findCategoriesWithoutTopFive(){
        return service.findCategoriesWithoutTopFive();
    }
}
