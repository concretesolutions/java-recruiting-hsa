/**
 * Backend Code Challenge - forked from concretesolutions/java-recruiting-hsa
 * 
 * Author: Jorge Leiva
 * Mail: jorgeleiva.17@gmail.com
 */
package com.concretesolutions.bffinitpage.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.concretesolutions.bffinitpage.entities.CategoriesRS;
import com.concretesolutions.bffinitpage.entities.Category;
import com.concretesolutions.bffinitpage.service.CategoriesService;

@RestController
@RequestMapping("/bff/v1/categories")
public class CategoriesController {

  CategoriesService categoriesService;

  @Autowired
  public CategoriesController(CategoriesService categoriesService) {
    this.categoriesService = categoriesService;
  }
  
  @GetMapping("/top-five")
  public CompletableFuture<List<Category>> getTopFiveCategories() {
    return categoriesService.getTopFiveCategories();
  }
  
  @GetMapping("/remaining")
  public CompletableFuture<List<Category>> getRemainingTopFiveCategories() {
    return categoriesService.getRemainingTopFiveCategories();
  }

  @PostMapping()
  public CompletableFuture<CategoriesRS> getAllCategories(@RequestParam(defaultValue = "5") int topCategories) {
    return categoriesService.getAllCategories(topCategories);
  }
}
