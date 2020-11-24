package com.accenture.prueba.client;

import com.accenture.prueba.dto.api.CategoriesApiResponse;

/**
 * Cliente de API categorias
 */
public interface CategoriesClient {

    /**
     * Obtener todas las categorias
     * @return Objeto con todas las categorias de la API
     */
    CategoriesApiResponse getAll();

}
