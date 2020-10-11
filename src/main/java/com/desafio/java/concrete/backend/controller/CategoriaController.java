package com.desafio.java.concrete.backend.controller;

import com.desafio.java.concrete.backend.services.CategoriesServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Categories")
@RequestMapping(value="/category")
public class CategoriaController {

    @Autowired
    CategoriesServices categoriesServices;

    @ApiOperation(value = "Top Categorias", notes = "Retorna el Top 5 en categorias.")
    @GetMapping(value = "/top-categories", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    String getTopCategories() {
        return categoriesServices.getTopCategories();
    }

    @ApiOperation(value = "Categorias fueras del top", notes = "Retorna las categorias que no estan dentro del top 5")
    @GetMapping(value = "/getCategories", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    String getCategories() {
        return categoriesServices.getCategories();
    }

}
