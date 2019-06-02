package com.concrete.challenge.bean.categories.external;

import com.concrete.challenge.bean.categories.structure.AbstractCategory;
import com.concrete.challenge.bean.categories.structure.Category;
import com.concrete.challenge.bean.categories.structure.IconImageUrl;
import com.concrete.challenge.bean.categories.structure.Subcategories;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor
public class SubCategoryLevel2
        extends AbstractCategory
        implements Category, IconImageUrl, Subcategories {

    private String iconImageUrl;
    private List<SubCategoryLevel3> subcategories;

    @Builder
    public SubCategoryLevel2(String id, String name, int relevance, String iconImageUrl, List<SubCategoryLevel3> subcategories) {
        super(id, name, relevance);
        this.iconImageUrl = iconImageUrl;
        this.subcategories = subcategories;
    }

    @Override
    public String getIconImageUrl() {
        return iconImageUrl;
    }

    @Override
    public List<SubCategoryLevel3> getSubcategories() {
        return Collections.unmodifiableList(subcategories);
    }
}
