package com.concrete.challenge.bean.categories.external;

import com.concrete.challenge.bean.categories.structure.AbstractCategory;
import com.concrete.challenge.bean.categories.structure.Category;
import com.concrete.challenge.bean.categories.structure.IconImageUrl;
import com.concrete.challenge.bean.categories.structure.Subcategories;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class SubCategoryLevel2
        extends AbstractCategory
        implements Category, IconImageUrl, Subcategories {

    private String iconImageUrl;
    private List<Category> subcategories;

    @Builder
    public SubCategoryLevel2(String id, String name, int relevance, String iconImageUrl, List<Category> subcategories) {
        super(id, name, relevance);
        this.iconImageUrl = iconImageUrl;
        this.subcategories = subcategories;
    }
}
