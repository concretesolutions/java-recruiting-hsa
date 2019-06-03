package com.concrete.challenge.bean.categories.adapted;

import com.concrete.challenge.bean.categories.structure.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@Getter
public class ASubCategoryLevel3 extends AbstractCategory
        implements LargeImageUrl, MediumImageUrl, SmallImageUrl, Subcategories {

    private List<Category> subcategories;
    private String largeImageUrl;
    private String mediumImageUrl;
    private String smallImageUrl;

    @Builder
    public ASubCategoryLevel3(String id, String name, int relevance, String largeImageUrl, String mediumImageUrl, String smallImageUrl, List<Category> subcategories) {
        super(id, name, relevance);
        this.largeImageUrl = largeImageUrl;
        this.mediumImageUrl = mediumImageUrl;
        this.smallImageUrl = smallImageUrl;
        this.subcategories = subcategories;
    }

    @Override
    public List<Category> getSubcategories() {
        return Collections.unmodifiableList(subcategories);
    }

}
