package com.concrete.desafio.categories;

import com.concrete.desafio.categories.api.Category;

import java.util.List;
import java.util.Objects;

public class CategoryResponse extends Category {

  private String iconImageUrl;
  private List<SubCategoryResponse> subcategories;

  public CategoryResponse() {}

  public CategoryResponse(
      final String id,
      final String name,
      final int relevance,
      final String iconImageUrl,
      final List<SubCategoryResponse> subcategories) {
    super(id, name, relevance);
    this.iconImageUrl = iconImageUrl;
    this.subcategories = subcategories;
  }

  public String getIconImageUrl() {
    return iconImageUrl;
  }

  public List<SubCategoryResponse> getSubcategories() {
    return subcategories;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    CategoryResponse that = (CategoryResponse) o;
    return Objects.equals(getIconImageUrl(), that.getIconImageUrl())
        && Objects.equals(getSubcategories(), that.getSubcategories());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getIconImageUrl(), getSubcategories());
  }
}
