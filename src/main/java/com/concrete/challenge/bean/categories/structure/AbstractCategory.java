package com.concrete.challenge.bean.categories.structure;

import com.concrete.challenge.bean.categories.structure.Category;
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

}
