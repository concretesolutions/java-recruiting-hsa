/**
 * Backend Code Challenge - forked from concretesolutions/java-recruiting-hsa
 * 
 * Author: Jorge Leiva
 * Mail: jorgeleiva.17@gmail.com
 */
package com.concretesolutions.bffinitpage.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.concretesolutions.bffinitpage.entities.CategoriesRS;
import com.concretesolutions.bffinitpage.entities.Category;

public interface CategoriesService {
  public CompletableFuture<List<Category>> getTopFiveCategories();
  public CompletableFuture<List<Category>> getRemainingTopFiveCategories();
  public CompletableFuture<CategoriesRS> getAllCategories(int maxCategories);
}
