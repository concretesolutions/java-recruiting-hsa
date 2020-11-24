package com.accenture.prueba.dto;

import com.accenture.prueba.dto.api.CategoriesApiResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Objeto de respuesta de categorias
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Builder
public class CategoriesResponseDto {

    /**
     * Lista de categorias
     */
    private List<Categorie> categories;

    /**
     * Objeto de categoria
     */
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @EqualsAndHashCode
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Categorie {

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
         * URL de imagen del icono
         */
        private String iconImageUrl;

        /**
         * URL de imagen larga
         * ignorada
         */
        @JsonIgnore
        private String largeImageUrl;

        /**
         * URL de imagen mediana
         * ignorada
         */
        @JsonIgnore
        private String mediumImageUrl;

        /**
         * URL de imagen pequeña
         */
        private String smallImageUrl;

        /**
         * Lista de subcategorias
         */
        private List<CategoriesApiResponse.SubCategorie> subcategories;

    }


}
