package com.concrete.challenge.converter;

import com.concrete.challenge.bean.categories.adapted.ASubCategoryLevel2;
import com.concrete.challenge.bean.categories.external.*;
import com.concrete.challenge.bean.categories.mobile.MobileSubCategoryLevel3;
import com.concrete.challenge.bean.categories.structure.Category;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CategoryConverter {

    public Category convertToMobile(Category category) {
        return category.convertToMobile(this);
    }

    public Category convertToMobile(CategoryThree category) {
        return category;
    }

    public Category convertToMobile(Categories category) {
        return category;
    }

    public Category convertToMobile(SubCategoryLevel2 category) {
        return ASubCategoryLevel2.builder()
                .id(category.getId())
                .name(category.getName())
                .relevance(category.getRelevance())
                .iconImageUrl(category.getIconImageUrl())
                .subcategories(category.getSubcategories()
                        .stream()
                        .map(this::convertToMobile)
                        .collect(Collectors.toList()
                        )
                )
                .build();
    }

    public Category convertToMobile(SubCategoryLevel3 category) {
        return MobileSubCategoryLevel3.builder()
                .id(category.getId())
                .name(category.getName())
                .relevance(category.getRelevance())
                .smallImageUrl(category.getSmallImageUrl())
                .subcategories(category.getSubcategories())
                .build();
    }

    public Category convertToMobile(SubCategoryLevel4 category) {
        return category;
    }

    public Category convertToMobile(MobileSubCategoryLevel3 category) {
        return category;
    }

}
