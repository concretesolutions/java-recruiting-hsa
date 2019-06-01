package com.concrete.challenge.bean.categories.external;

import com.concrete.challenge.bean.categories.structure.AbstractCategory;
import com.concrete.challenge.bean.categories.structure.Category;
import com.concrete.challenge.bean.categories.structure.Subcategories;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class CategoryThree extends AbstractCategory
        implements Category, Subcategories {

    private List<Category> subcategories;

    @Builder
    public CategoryThree(String id, String name, int relevance, List<Category> subcategories) {
        super(id, name, relevance);
        this.subcategories = subcategories;
    }
}
