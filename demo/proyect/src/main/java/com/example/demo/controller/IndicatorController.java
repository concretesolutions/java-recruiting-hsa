package com.example.demo.controller;


import com.example.demo.dto.ResponseDTO;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IndicatorController {

    private final CategoryService categoryService;

    @Autowired
    public IndicatorController(CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getAll() {

        ResponseDTO indicator = categoryService.getAll();
        return new ResponseEntity<>(indicator, HttpStatus.OK);

    }



}
