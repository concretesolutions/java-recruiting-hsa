package com.concrete.challenge.bean.categories.external;

import com.concrete.challenge.bean.categories.structure.AbstractCategory;
import com.concrete.challenge.bean.categories.structure.Category;
import com.concrete.challenge.bean.categories.structure.LargeImageUrl;
import com.concrete.challenge.bean.categories.structure.MediumImageUrl;
import com.concrete.challenge.bean.categories.structure.SmallImageUrl;
import com.concrete.challenge.bean.categories.structure.Subcategories;
import com.concrete.challenge.bean.categories.structure.behaviour.ConvertToMobile;
import com.concrete.challenge.converter.CategoryConverter;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor
public class SubCategoryLevel3
        extends AbstractCategory
        implements LargeImageUrl, MediumImageUrl, SmallImageUrl, Subcategories, ConvertToMobile {

    private List<SubCategoryLevel4> subcategories;
    private String largeImageUrl;
    private String mediumImageUrl;
    private String smallImageUrl;

    @Builder
    public SubCategoryLevel3(String id, String name, int relevance, String largeImageUrl, String mediumImageUrl, String smallImageUrl, List<SubCategoryLevel4> subcategories) {
        super(id, name, relevance);
        this.largeImageUrl = largeImageUrl;
        this.mediumImageUrl = mediumImageUrl;
        this.smallImageUrl = smallImageUrl;
        this.subcategories = subcategories;
    }

    @Override
    public List<SubCategoryLevel4> getSubcategories() {
        return Collections.unmodifiableList(subcategories);
    }

    @Override
    public String getLargeImageUrl() {
        return largeImageUrl;
    }

    @Override
    public String getMediumImageUrl() {
        return mediumImageUrl;
    }

    @Override
    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    @Override
    public Category convertToMobile(CategoryConverter care) {
        return care.convertToMobile(this);
    }
}
