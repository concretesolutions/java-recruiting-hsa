package com.example.demo.service;


import com.example.demo.dto.CategoryBase;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.SubcategoryDTO;
import com.example.demo.feign.CategoryFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {


    private final CategoryFeignClient categoryFeignClient;

    @Autowired
    public CategoryServiceImpl(CategoryFeignClient categoryFeignClient) {
        this.categoryFeignClient = categoryFeignClient;
    }

    @Override
    public ResponseDTO getAll() {
        log.info(" Método  getAll ");

        ResponseDTO responseDTO = categoryFeignClient.getAll();
        List<SubcategoryDTO> topSubcategories = getTopSubcategories(responseDTO.getSubcategories());

        responseDTO.getSubcategories().stream()
                .findFirst()
                .ifPresent(subcategoryDTO -> subcategoryDTO.setSubcategories(topSubcategories));

        return responseDTO;

    }


    private List<SubcategoryDTO> getTopSubcategories(List<CategoryBase> categories) {


        Predicate<SubcategoryDTO> hasSubcategories = subcategory -> subcategory.getSubcategories() != null;
        Comparator<SubcategoryDTO> byRelevanceDesc = Comparator.comparingInt(SubcategoryDTO::getRelevance).reversed();


        return categories.stream()
                .flatMap(category -> category.getSubcategories().stream())
                .filter(hasSubcategories)
                .sorted(byRelevanceDesc)
                .limit(5)
                .collect(Collectors.toList());

    }

}
