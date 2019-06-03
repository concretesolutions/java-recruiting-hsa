package com.concrete.challenge.bean.categories.structure;

import com.concrete.challenge.converter.CategoryConverter;
import lombok.Getter;

@Getter
public abstract class AbstractCategory implements Category {

    private String id;
    private String name;
    private int relevance;

    protected AbstractCategory() {

    }

    protected AbstractCategory(String id, String name, int relevance) {
        this.id = id;
        this.name = name;
        this.relevance = relevance;
    }

    @Override
    public Category convertToMobile(CategoryConverter care) {
        return this;
    }

}
