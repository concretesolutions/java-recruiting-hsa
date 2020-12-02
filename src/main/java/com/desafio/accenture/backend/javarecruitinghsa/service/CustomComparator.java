package com.desafio.accenture.backend.javarecruitinghsa.service;

import com.desafio.accenture.backend.javarecruitinghsa.dto.ProductsSubCategoryDTO;

import java.util.Comparator;

public class CustomComparator implements Comparator<ProductsSubCategoryDTO> {

    @Override
    public int compare(ProductsSubCategoryDTO o1, ProductsSubCategoryDTO o2) {
        return o1.getRelevance().compareTo(o2.getRelevance());
    }
}
