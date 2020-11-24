package com.accenture.prueba.service;

import com.accenture.prueba.dto.CategoriesResponseDto;

/**
 * Servicio de categorias
 */
public interface CategoriesService {

    /**
     * Obtener todas
     * @return Objeto mapeado con lista de categorias
     */
    CategoriesResponseDto getAll();

    /**
     * Obtener top
     * @return Objeto mapeado con lista de categorias
     */
    CategoriesResponseDto getTop();

    /**
     * Obtener resto no top
     * @return Objeto mapeado con lista de categorias
     */
    CategoriesResponseDto getAnother();

}
