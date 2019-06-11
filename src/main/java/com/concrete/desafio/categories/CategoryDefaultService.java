package com.concrete.desafio.categories;

import com.concrete.desafio.categories.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryDefaultService implements CategoryService {

  private CategoryRepository categoryRepository;
  private static final String MOBILE_MARKET_ID = "MOB";

  @Autowired
  public CategoryDefaultService(final CategoryRepository categoryResponse) {
    this.categoryRepository = categoryResponse;
  }

  @Override
  public ResponseEntity<List<CategoryResponse>> topFiveCategories() {
    return new ResponseEntity<>(getTopFiveCategories(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<CategoryResponse>> remainingCategories() {
    List<SubcategoryLvTwo> subcategoryLvTwo = sortSubCategoryLvTwo();
    List<String> topCategoryNameList =
        getTopFiveCategories().stream().map(CategoryResponse::getName).collect(Collectors.toList());
    return new ResponseEntity<>(
        mapCategories(subcategoryLvTwo).stream()
            .filter(sub -> !topCategoryNameList.contains(sub.getName()))
            .collect(Collectors.toList()),
        HttpStatus.OK);
  }

  private List<CategoryResponse> getTopFiveCategories() {
    List<SubcategoryLvTwo> subcategoryLvTwo = sortSubCategoryLvTwo();
    return mapCategories(subcategoryLvTwo).stream().limit(5).collect(Collectors.toList());
  }

  private List<SubcategoryLvTwo> sortSubCategoryLvTwo() {
    CategoryThree categoryThree = categoryRepository.getCategoryThree().getBody();

    if (categoryThree.getSubcategories() == null) {
      throw new IllegalArgumentException("SubCategories can not be null");
    }

    return FilterMobileCategories(categoryThree.getSubcategories()).getSubcategories().stream()
        .sorted(Comparator.comparing(SubcategoryLvTwo::getRelevance))
        .collect(Collectors.toList());
  }

  private Subcategory FilterMobileCategories(List<Subcategory> subcategories) {
    if (subcategories == null) {
      throw new IllegalArgumentException("SubCategories can not be null");
    }

    return subcategories.stream()
        .filter(subcategory -> MOBILE_MARKET_ID.equalsIgnoreCase(subcategory.getId()))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Mobile market category not found"));
  }

  private List<CategoryResponse> mapCategories(List<SubcategoryLvTwo> subCategories) {

    return subCategories.stream()
        .map(
            sub ->
                new CategoryResponse(
                    sub.getId(),
                    sub.getName(),
                    sub.getRelevance(),
                    sub.getIconImageUrl(),
                    mapSubCategory(sub.getSubcategories())))
        .collect(Collectors.toList());
  }

  private List<SubCategoryResponse> mapSubCategory(
      List<SubcategoryLvThree> subcategoryLvThreeList) {
    return subcategoryLvThreeList.stream()
        .map(
            sub ->
                new SubCategoryResponse(
                    sub.getId(),
                    sub.getName(),
                    sub.getRelevance(),
                    sub.getSmallImageUrl(),
                    sub.getSubcategories()))
        .collect(Collectors.toList());
  }
}
