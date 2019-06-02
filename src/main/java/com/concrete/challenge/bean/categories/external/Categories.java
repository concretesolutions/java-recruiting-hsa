package com.concrete.challenge.bean.categories.external;

import com.concrete.challenge.bean.categories.structure.AbstractCategory;
import com.concrete.challenge.bean.categories.structure.Subcategories;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor
public class Categories extends AbstractCategory
        implements Subcategories {

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
}
