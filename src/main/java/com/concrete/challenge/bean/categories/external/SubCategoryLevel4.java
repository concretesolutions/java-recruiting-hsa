package com.concrete.challenge.bean.categories.external;

import com.concrete.challenge.bean.categories.mobile.behaviour.ConvertToMobile;
import com.concrete.challenge.bean.categories.structure.AbstractCategory;
import com.concrete.challenge.bean.categories.structure.Category;
import com.concrete.challenge.converter.CategoryConverter;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SubCategoryLevel4 extends AbstractCategory implements ConvertToMobile {

    @Builder
    public SubCategoryLevel4(String id, String name, int relevance) {
        super(id, name, relevance);
    }

    @Override
    public Category convertToMobile(CategoryConverter care) {
        return care.convertToMobile(this);
    }
}
