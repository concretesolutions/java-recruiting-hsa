package com.concrete.challenge.service;

import com.concrete.challenge.bean.categories.external.SubCategoryLevel2;
import com.concrete.challenge.bean.categories.structure.Category;
import com.concrete.challenge.client.categories.CategoriesRepository;
import com.concrete.challenge.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private Converter categoryConverter;

    public List<Category> getTopCategories(int relevantCategories) {
        return categoriesRepository.getCategory()
                .getSubcategories()
                .stream()
                .flatMap(x -> x.getSubcategories().stream())
                .sorted(Comparator.comparing(SubCategoryLevel2::getRelevance))
                .limit(relevantCategories)
                .collect(Collectors.toList());
    }

    public List<Category> getTopCategoriesAfterTop(int relevantCategories) {
        return categoriesRepository.getCategory()
                .getSubcategories()
                .stream()
                .flatMap(x -> x.getSubcategories().stream())
                .sorted(Comparator.comparing(SubCategoryLevel2::getRelevance))
                .skip(relevantCategories)
                .collect(Collectors.toList());
    }

    public List<Category> getMobileTopCategoriesAfterTop(int relevantCategories) {
        return getTopCategoriesAfterTop(relevantCategories)
                .stream()
                .map(category -> categoryConverter.convertToMobile(category))
                .collect(Collectors.toList());
    }

    public List<Category> getMobileTopCategories(int relevantCategories) {
        return getTopCategories(relevantCategories)
                .stream()
                .map(category -> categoryConverter.convertToMobile(category))
                .collect(Collectors.toList());
    }

}
