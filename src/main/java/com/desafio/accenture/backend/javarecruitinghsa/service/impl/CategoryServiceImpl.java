package com.desafio.accenture.backend.javarecruitinghsa.service.impl;

import com.desafio.accenture.backend.javarecruitinghsa.dto.CategoriesDTO;
import com.desafio.accenture.backend.javarecruitinghsa.dto.ProductsSubCategoryDTO;
import com.desafio.accenture.backend.javarecruitinghsa.dto.SubCategoryDTO;
import com.desafio.accenture.backend.javarecruitinghsa.exception.GenericException;
import com.desafio.accenture.backend.javarecruitinghsa.feign.CategoriesFeignClient;
import com.desafio.accenture.backend.javarecruitinghsa.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    CategoriesFeignClient categoriesFeignClient;

    @Override
    public List<ProductsSubCategoryDTO> getAllCategoriesTopFive() throws GenericException {

        ResponseEntity<CategoriesDTO> categoriesDTO = categoriesFeignClient.getCategories();

        return Optional.ofNullable(categoriesDTO)
                .filter(c -> c.getStatusCode().is2xxSuccessful())
                .map(co -> getCategoriesTopFiveOrdered(Objects.requireNonNull(co.getBody())))
                .orElseThrow(() -> new GenericException("Error al obtener las Categorias", 1));

    }

    @Override
    public List<ProductsSubCategoryDTO> getRestCategoriesExceptTopFive() throws GenericException {

        ResponseEntity<CategoriesDTO> categoriesDTO = categoriesFeignClient.getCategories();

       return Optional.ofNullable(categoriesDTO)
                .filter(c -> c.getStatusCode().is2xxSuccessful())
                .map(co -> getRestCategoriesExceptTopFiveOrdered(Objects.requireNonNull(co.getBody())))
                .orElseThrow(() -> new GenericException("Error al obtener las Categorias", 1));


    }

    private List<ProductsSubCategoryDTO> getRestCategoriesExceptTopFiveOrdered(CategoriesDTO categories) {

        return categories.getSubcategories().stream()
                .map(SubCategoryDTO::getSubcategories)
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(ProductsSubCategoryDTO::getRelevance).reversed())
                .skip(5)
                .collect(Collectors.toList());

    }

    private List<ProductsSubCategoryDTO> getCategoriesTopFiveOrdered(CategoriesDTO categories) {

       return categories.getSubcategories().stream()
                .map(SubCategoryDTO::getSubcategories)
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(ProductsSubCategoryDTO::getRelevance).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }
}
