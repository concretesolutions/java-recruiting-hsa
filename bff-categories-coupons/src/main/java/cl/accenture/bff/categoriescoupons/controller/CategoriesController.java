package cl.accenture.bff.categoriescoupons.controller;

import cl.accenture.bff.categoriescoupons.dto.Category;
import cl.accenture.bff.categoriescoupons.service.CategoriesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * Copyright (c) 2023 Boris Molina
 */
@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    private final CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping
    @Operation(summary = "Obtiene las categorías",
            description = "Retorna las categorías",
            responses = {
                    @ApiResponse(
                            description = "Categorías obtenidas con éxito",
                            responseCode = "200", content = @Content),
                    @ApiResponse(
                            description = "Error interno del servidor",
                            responseCode = "500", content = @Content)
            })
    public ResponseEntity<Category> getCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(categoriesService.getCategories());
    }

    @GetMapping("/top5")
    @Operation(summary = "Obtiene las TOP 5 categorías",
            description = "Retorna el TOP 5 categorías",
            responses = {
                    @ApiResponse(
                            description = "TOP 5 categorías obtenidas con éxito",
                            responseCode = "200", content = @Content),
                    @ApiResponse(
                            description = "Error interno del servidor",
                            responseCode = "500", content = @Content)
            })
    public ResponseEntity<List<Category>> getTop5Categories() {
        return ResponseEntity.status(HttpStatus.OK).body(categoriesService.getTop5Categories());
    }

}
