package com.aptiliux.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aptiliux.dto.category.Category;
import com.aptiliux.dto.json.view.Views;
import com.aptiliux.service.CategoryService;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @CrossOrigin(origins = "*")
    @ApiOperation(value = "Return categories ordered by relevance")
    @GetMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> getCategories(
    		@RequestParam(name="offset",required=false) Long offset,
    		@RequestParam(name="limit",required=false) Long limit) {
        return new ResponseEntity<>(categoryService.getTopCategories(offset, limit), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @ApiOperation(value = "Return categories ordered by relevance")
    @GetMapping(value = "/mobile/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(Views.Mobile.class) 
    public ResponseEntity<List<Category>> getCategoriesMobile(
    		@RequestParam(name="offset",required=false) Long offset,
    		@RequestParam(name="limit",required=false) Long limit) {
        return new ResponseEntity<>(categoryService.getTopCategories(offset, limit), HttpStatus.OK);
    }
}
