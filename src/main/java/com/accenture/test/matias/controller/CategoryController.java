package com.accenture.test.matias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.test.matias.dto.CategoriesDTO;
import com.accenture.test.matias.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * Method that expose a REST service that gets the categories separated by
     * top and no-top categories.
     * 
     * @param quantity Quantity to separate beetween top and no-top
     *        categories.
     * @return DTO with two categories list. First one with the top {quantity}
     *         categories ordered by his relevance.
     */
    @GetMapping("/top-relevance/{quantity}")
    public ResponseEntity<CategoriesDTO> getTopCategories(@PathVariable("quantity") int quantity) {

        log.info("[CategoryController][getTopCategories] Inicio.");
        CategoriesDTO resp = categoryService.getCategories(quantity);
        log.info("[CategoryController][getTopCategories] Fin.");

        return new ResponseEntity<CategoriesDTO>(resp, HttpStatus.OK);
    }

}
