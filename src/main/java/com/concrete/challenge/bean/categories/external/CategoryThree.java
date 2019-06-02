package com.concrete.challenge.bean.categories.external;

import com.concrete.challenge.bean.categories.structure.AbstractCategory;
import com.concrete.challenge.bean.categories.structure.Subcategories;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor
public class CategoryThree extends AbstractCategory
        implements Subcategories {

    private List<Categories> subcategories;

    @Builder
    public CategoryThree(String id, String name, int relevance, List<Categories> subcategories) {
        super(id, name, relevance);
        this.subcategories = subcategories;
    }

    @Override
    public List<Categories> getSubcategories() {
        return Collections.unmodifiableList(subcategories);
    }
}
