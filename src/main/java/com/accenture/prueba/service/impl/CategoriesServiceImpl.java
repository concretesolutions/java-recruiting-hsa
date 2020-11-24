package com.accenture.prueba.service.impl;

import com.accenture.prueba.client.CategoriesClient;
import com.accenture.prueba.dto.CategoriesResponseDto;
import com.accenture.prueba.dto.api.CategoriesApiResponse;
import com.accenture.prueba.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @see com.accenture.prueba.service.CategoriesService
 */
@Service
@RequiredArgsConstructor
public class CategoriesServiceImpl implements CategoriesService {

    /**
     * Bean de cliente de api de categorias
     */
    private final CategoriesClient categoriesClient;

    /**
     * @see CategoriesService#getAll()
     */
    @Override
    public CategoriesResponseDto getAll() {
        List<CategoriesResponseDto.Categorie> categoriesList = extractCategories(categoriesClient.getAll());

        return CategoriesResponseDto.builder()
                .categories(categoriesList)
                .build();
    }

    /**
     * @see CategoriesService#getTop()
     */
    @Override
    public CategoriesResponseDto getTop() {
        List<CategoriesResponseDto.Categorie> categoriesList = getAll().getCategories()
                .stream()
                .sorted((c1, c2) -> c2.getRelevance() - c1.getRelevance())
                .collect(Collectors.toList());

        return CategoriesResponseDto.builder()
                .categories(categoriesList.subList(0, Math.min(categoriesList.size(), 5)))
                .build();
    }

    /**
     * @see CategoriesService#getAnother()
     */
    @Override
    public CategoriesResponseDto getAnother() {
        List<CategoriesResponseDto.Categorie> categoriesList = getAll().getCategories()
                .stream()
                .sorted((c1, c2) -> c2.getRelevance() - c1.getRelevance())
                .collect(Collectors.toList());

        List<CategoriesResponseDto.Categorie> topCategoriesList = categoriesList.subList(0, Math.min(categoriesList.size(), 5));

        categoriesList.removeAll(topCategoriesList);

        return CategoriesResponseDto.builder()
                .categories(categoriesList)
                .build();
    }

    /**
     * Metodo que extrae las subcategorias para manipularlas
     * @param response Objeto de respuesta de API
     * @return Lista de categorias en objeto de dominio
     */
    private static List<CategoriesResponseDto.Categorie> extractCategories(CategoriesApiResponse response) {
        List<CategoriesResponseDto.Categorie> result = new ArrayList<>();

        response.getSubcategories().get(0).getSubcategories().forEach(categorie -> {
            result.add(CategoriesResponseDto.Categorie.builder()
                    .id(categorie.getId())
                    .name(categorie.getName())
                    .relevance(categorie.getRelevance())
                    .iconImageUrl(categorie.getIconImageUrl())
                    .subcategories(categorie.getSubcategories())
                    .build());
        });

        return result;
    }

}
