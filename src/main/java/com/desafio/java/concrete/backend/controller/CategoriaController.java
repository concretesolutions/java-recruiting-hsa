package com.desafio.java.concrete.backend.controller;

import com.desafio.java.concrete.backend.helpers.ObjectJsonHelper;
import com.desafio.java.concrete.backend.services.CategoriesServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CategoriaController {

    @Autowired
    CategoriesServices categoriesServices;

    @GetMapping(value = "/top-categories", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    String getTopCategories() {
        return categoriesServices.getTopCategories();
    }

    @GetMapping(value = "/getCategories", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    String getCategories() {
        return categoriesServices.getCategories();
    }

    @GetMapping(value = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String ping() {
        return ObjectJsonHelper.successMessage("success");
    }
}
