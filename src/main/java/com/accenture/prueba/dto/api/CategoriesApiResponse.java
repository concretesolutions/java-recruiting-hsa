package com.accenture.prueba.dto.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * Objeto de respuesta de respuesta de API de categorias
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoriesApiResponse {

    /**
     * Id
     */
    private String id;

    /**
     * Nombre
     */
    private String name;

    /**
     * Subcategorias
     */
    private List<SubCategorie> subcategories;

    /**
     * Objeto de subcategorias de respuesta de API de categorias
     */
    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class SubCategorie {

        /**
         * Id
         */
        private String id;

        /**
         * Nombre
         */
        private String name;

        /**
         * Relevancia
         */
        private int relevance;

        /**
         * URL de imagen icono
         */
        private String iconImageUrl;

        /**
         * URL de imagen larga
         */
        private String largeImageUrl;

        /**
         * URL de imagen mediana
         */
        private String mediumImageUrl;

        /**
         * URL de imagen pequeña
         */
        private String smallImageUrl;

        /**
         * Subcategorias
         */
        private List<SubCategorie> subcategories;

    }

}
