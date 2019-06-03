package com.concrete.challenge.bean.categories.mobile;

import com.concrete.challenge.bean.categories.external.SubCategoryLevel4;
import com.concrete.challenge.bean.categories.structure.AbstractCategory;
import com.concrete.challenge.bean.categories.structure.Category;
import com.concrete.challenge.bean.categories.structure.SmallImageUrl;
import com.concrete.challenge.bean.categories.structure.Subcategories;
import com.concrete.challenge.converter.CategoryConverter;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class MobileSubCategoryLevel3 extends AbstractCategory
        implements SmallImageUrl, Subcategories {

    private List<SubCategoryLevel4> subcategories;
    private String smallImageUrl;

    @Builder
    public MobileSubCategoryLevel3(String id, String name, int relevance, String smallImageUrl, List<SubCategoryLevel4> subcategories) {
        super(id, name, relevance);
        this.smallImageUrl = smallImageUrl;
        this.subcategories = subcategories;
    }

    @Override
    public Category convertToMobile(CategoryConverter care) {
        return care.convertToMobile(this);
    }
}
