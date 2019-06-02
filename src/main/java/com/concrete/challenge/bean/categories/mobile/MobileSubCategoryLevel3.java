package com.concrete.challenge.bean.categories.mobile;

import com.concrete.challenge.bean.categories.structure.AbstractCategory;
import com.concrete.challenge.bean.categories.structure.Category;
import com.concrete.challenge.bean.categories.structure.SmallImageUrl;
import com.concrete.challenge.bean.categories.structure.Subcategories;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class MobileSubCategoryLevel3 extends AbstractCategory
        implements Category, SmallImageUrl, Subcategories {

    List<Category> subcategories;
    private String smallImageUrl;

    @Builder
    public MobileSubCategoryLevel3(String id, String name, int relevance, String smallImageUrl, List<Category> subcategories) {
        super(id, name, relevance);
        this.smallImageUrl = smallImageUrl;
        this.subcategories = subcategories;
    }
}
