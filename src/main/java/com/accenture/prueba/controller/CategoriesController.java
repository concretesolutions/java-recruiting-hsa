package com.accenture.prueba.controller;

import com.accenture.prueba.dto.CategoriesResponseDto;
import com.accenture.prueba.service.CategoriesService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de funciones de categorias
 */
@RestController
@RequestMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CategoriesController {

    /**
     * Bean de servicio de categorias
     */
    private final CategoriesService categoriesService;

    /**
     * Endpoint para obtener todas las categorias
     * @return Objeto con lista de categorias
     */
    @ApiOperation("Obtener todas las categorias")
    @GetMapping(value = "")
    public CategoriesResponseDto getAllCategories() {
        return categoriesService.getAll();
    }

    /**
     * Endpoint para obtener el top de categorias
     * @return Objeto con lista de categorias
     */
    @ApiOperation("Obtener las categorias top 5")
    @GetMapping(value = "/top")
    public CategoriesResponseDto getTopCategories() {
        return categoriesService.getTop();
    }

    /**
     * Endpoint para obtener las demas categorias fuera del top
     * @return Objeto con lista de categorias
     */
    @ApiOperation("Obtener las categorias que no estan dentro de las top 5")
    @GetMapping(value = "/another")
    public CategoriesResponseDto getAnotherCategories() {
        return categoriesService.getAnother();
    }

}
