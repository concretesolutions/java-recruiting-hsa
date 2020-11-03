/**
 * Backend Code Challenge - forked from concretesolutions/java-recruiting-hsa
 * 
 * Author: Jorge Leiva
 * Mail: jorgeleiva.17@gmail.com
 */
package com.concretesolutions.bffinitpage.entities;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class CategoriesRS {
  private List<Category> topCategories;
  private List<Category> remainingCategories;

  public CategoriesRS() {
    super();
  }

  public List<Category> getTopCategories() {
    if (topCategories == null) {
      return new ArrayList<>();
    }
    return new ArrayList<>(topCategories);
  }

  public void setTopCategories(List<Category> topCategories) {
    this.topCategories = new ArrayList<>(topCategories);
  }

  public List<Category> getRemainingCategories() {
    if (remainingCategories == null) {
      return new ArrayList<>();
    }
    return new ArrayList<>(remainingCategories);
  }

  public void setRemainingCategories(List<Category> remainingCategories) {
    this.remainingCategories = new ArrayList<>(remainingCategories);
  }

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }
}
