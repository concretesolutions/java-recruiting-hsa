/**
 * Backend Code Challenge - forked from concretesolutions/java-recruiting-hsa
 * 
 * Author: Jorge Leiva
 * Mail: jorgeleiva.17@gmail.com
 */
package com.concretesolutions.bffinitpage.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.concretesolutions.bffinitpage.config.ServiceConfig;
import com.concretesolutions.bffinitpage.entities.CategoriesRS;
import com.concretesolutions.bffinitpage.entities.Category;
import com.concretesolutions.bffinitpage.service.CategoriesService;
import com.concretesolutions.bffinitpage.utils.ServiceUtils;

@Service
public class CategoriesImpl implements CategoriesService {

  private static final Logger LOG = LoggerFactory.getLogger(CategoriesImpl.class);
  private static final Integer FIVE = 5;
  private ServiceConfig serviceConfig;
  private RestTemplate restTemplate;

  @Autowired
  public CategoriesImpl(ServiceConfig serviceConfig, RestTemplate restTemplate) {
    this.serviceConfig = serviceConfig;
    this.restTemplate = restTemplate;
  }

  @Override
  @Async
  public CompletableFuture<List<Category>> getTopFiveCategories() {
    return CompletableFuture.completedFuture(obtainCategories(FIVE).getTopCategories());
  }

  @Override
  @Async
  public CompletableFuture<List<Category>> getRemainingTopFiveCategories() {
    return CompletableFuture.completedFuture(obtainCategories(FIVE).getRemainingCategories());
  }

  @Override
  @Async
  public CompletableFuture<CategoriesRS> getAllCategories(int maxCategories) {
    return CompletableFuture.completedFuture(obtainCategories(maxCategories));
  }

  private CategoriesRS obtainCategories(int maxCategories) {
    String url = serviceConfig.getCategoriesendpoint();
    LOG.info("Get Top " + maxCategories + " Categories from " + url);
    Category categoryResponse = restTemplate.getForObject(url, Category.class);
    CategoriesRS result = new CategoriesRS();
    categoryResponse.getSubcategories().forEach((Category mob) -> {
      if (mob != null && ServiceUtils.isNonEmpty(mob.getName())
          && mob.getName().equalsIgnoreCase(serviceConfig.getMobileCategory())) {
        List<Category> toOrder = mob.getSubcategories();
        Collections.sort(toOrder, new Category());
        List<Category> top = new ArrayList<>();
        List<Category> remaining = new ArrayList<>();
        toOrder.forEach((Category toAdd) -> {
          if (toAdd != null) {
            if (maxCategories > 0 && top.size() < maxCategories) {
              top.add(toAdd);
            } else {
              remaining.add(toAdd);
            }
          }
        });
        result.setTopCategories(top);
        result.setRemainingCategories(remaining);
      }
    });
    return result;
  }

}
