package com.concrete.challenge.bean.categories.adapted;

import com.concrete.challenge.bean.categories.structure.AbstractCategory;
import com.concrete.challenge.bean.categories.structure.Category;
import com.concrete.challenge.bean.categories.structure.Subcategories;
import lombok.Builder;

import java.util.Collections;
import java.util.List;

public class ACategoryThree
        extends AbstractCategory
        implements Subcategories {

    private List<Category> subcategories;

    @Builder
    public ACategoryThree(String id, String name, int relevance, List<Category> subcategories) {
        super(id, name, relevance);
        this.subcategories = subcategories;
    }

    @Override
    public List<Category> getSubcategories() {
        return Collections.unmodifiableList(subcategories);
    }
}
