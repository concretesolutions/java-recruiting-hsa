package com.concrete.challenge.bean.categories.external;

import com.concrete.challenge.bean.categories.structure.AbstractCategory;
import com.concrete.challenge.bean.categories.structure.Category;
import com.concrete.challenge.bean.categories.structure.Subcategories;
import com.concrete.challenge.bean.categories.structure.behaviour.ConvertToMobile;
import com.concrete.challenge.converter.CategoryConverter;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor
public class Categories extends AbstractCategory
        implements Subcategories, ConvertToMobile {

    private List<SubCategoryLevel2> subcategories;

    @Builder
    public Categories(String id, String name, int relevance, List<SubCategoryLevel2> subcategories) {
        super(id, name, relevance);
        this.subcategories = subcategories;
    }

    @Override
    public List<SubCategoryLevel2> getSubcategories() {
        return Collections.unmodifiableList(subcategories);
    }

    @Override
    public Category convertToMobile(CategoryConverter care) {
        return care.convertToMobile(this);
    }
}
