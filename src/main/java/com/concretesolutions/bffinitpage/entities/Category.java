/**
 * Backend Code Challenge - forked from concretesolutions/java-recruiting-hsa
 * 
 * Author: Jorge Leiva
 * Mail: jorgeleiva.17@gmail.com
 */
package com.concretesolutions.bffinitpage.entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Category implements Comparator<Category> {
  private String id;
  private String name;
  private List<Category> subcategories;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Integer relevance;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String smallImageUrl;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String iconImageUrl;

  public Category() {
    super();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Category> getSubcategories() {
    if (subcategories == null) {
      return new ArrayList<>();
    }
    return new ArrayList<>(subcategories);
  }

  public void setSubcategories(List<Category> subcategories) {
    this.subcategories = new ArrayList<>(subcategories);
  }

  public Integer getRelevance() {
    return relevance;
  }

  public void setRelevance(Integer relevance) {
    this.relevance = relevance;
  }

  public String getSmallImageUrl() {
    return smallImageUrl;
  }

  public void setSmallImageUrl(String smallImageUrl) {
    this.smallImageUrl = smallImageUrl;
  }

  public String getIconImageUrl() {
    return iconImageUrl;
  }

  public void setIconImageUrl(String iconImageUrl) {
    this.iconImageUrl = iconImageUrl;
  }

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }

  @Override
  public int compare(Category cat1, Category cat2) {
    int val1 = (cat1.getRelevance() != null) ? cat1.getRelevance() : 0;
    int val2 = (cat2.getRelevance() != null) ? cat2.getRelevance() : 0;
    if (val1 == val2) {
      return 0;
    }
    return (val1 > val2) ? -1 : 1;
  }

}
