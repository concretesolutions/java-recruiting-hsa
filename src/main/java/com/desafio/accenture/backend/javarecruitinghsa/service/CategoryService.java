package com.desafio.accenture.backend.javarecruitinghsa.service;

import com.desafio.accenture.backend.javarecruitinghsa.dto.CategoriesDTO;
import com.desafio.accenture.backend.javarecruitinghsa.dto.ProductsSubCategoryDTO;
import com.desafio.accenture.backend.javarecruitinghsa.exception.GenericException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<ProductsSubCategoryDTO> getAllCategoriesTopFive() throws GenericException;

    List<ProductsSubCategoryDTO> getRestCategoriesExceptTopFive() throws GenericException;
}
