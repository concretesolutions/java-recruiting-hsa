package com.concrete.challenge.bean.categories.adapted;

import com.concrete.challenge.bean.categories.structure.AbstractCategory;
import lombok.Builder;

public class ASubCategoryLevel4 extends AbstractCategory {

    @Builder
    public ASubCategoryLevel4(String id, String name, int relevance) {
        super(id, name, relevance);
    }
}
