package com.concrete.challenge.bean.categories.external;

import com.concrete.challenge.bean.categories.structure.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class SubCategoryLevel3
        extends AbstractCategory
        implements Category, LargeImageUrl, MediumImageUrl, SmallImageUrl, Subcategories {

    private String largeImageUrl;
    private String mediumImageUrl;
    private String smallImageUrl;
    List<Category> subcategories;

    @Builder
    public SubCategoryLevel3(String id, String name, int relevance, String largeImageUrl, String mediumImageUrl, String smallImageUrl, List<Category> subcategories) {
        super(id, name, relevance);
        this.largeImageUrl = largeImageUrl;
        this.mediumImageUrl = mediumImageUrl;
        this.smallImageUrl = smallImageUrl;
        this.subcategories = subcategories;
    }
}
