package com.desafio.accenture.backend.javarecruitinghsa.controller;

import com.desafio.accenture.backend.javarecruitinghsa.dto.CouponsDTO;
import com.desafio.accenture.backend.javarecruitinghsa.dto.ProductsSubCategoryDTO;
import com.desafio.accenture.backend.javarecruitinghsa.exception.GenericException;
import com.desafio.accenture.backend.javarecruitinghsa.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriesController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/top-categories", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ProductsSubCategoryDTO>> getTopCategories() {
        List<ProductsSubCategoryDTO> categoryDTOList = null;

        try {
            categoryDTOList = categoryService.getAllCategoriesTopFive();
            return new ResponseEntity<>(categoryDTOList, HttpStatus.OK);

        } catch (GenericException e) {
            return new ResponseEntity<>((List<ProductsSubCategoryDTO>) new ProductsSubCategoryDTO().buildErrorResponse(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/getCategories", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ProductsSubCategoryDTO>> getCategories() {
        List<ProductsSubCategoryDTO> categoryDTOList = null;

        try {
            categoryDTOList = categoryService.getRestCategoriesExceptTopFive();
            return new ResponseEntity<>(categoryDTOList, HttpStatus.OK);

        } catch (GenericException e) {
            return new ResponseEntity<>((List<ProductsSubCategoryDTO>) new ProductsSubCategoryDTO().buildErrorResponse(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
