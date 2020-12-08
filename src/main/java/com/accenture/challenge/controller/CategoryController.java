package com.accenture.challenge.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.accenture.challenge.mapper.Category;
import com.google.gson.Gson;

@RestController
public class CategoryController {

   @Autowired
   RestTemplate restTemplate;

   @RequestMapping(value = "/api/all-categories")
   public String getcategoriesList() {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity <String> entity = new HttpEntity<String>(headers);
      
	  return
		  restTemplate.exchange(
			  "https://cs-hsa-api-categories.herokuapp.com/categories", 
			  HttpMethod.GET, 
			  entity, 
			  String.class
			).getBody();
   }
   
   @RequestMapping(value = "/api/top-five-categories")
   public String getTopFiveCategoriesList() throws ParseException {
      String response = this.getcategoriesList();
      Category categoryTree = new Gson().fromJson(response, Category.class);

      ArrayList<Category> oneLevel = new ArrayList<Category>();

      for (Category category : categoryTree.getSubCategories()) {
         if(category.getSubCategories() != null){
            for (Category subcategory : category.getSubCategories()) {
               if(subcategory.getSubCategories() != null){
                  for (Category subsubcategory : subcategory.getSubCategories()) {
                     if(subsubcategory.getSubCategories() != null){
                        for (Category subsubsubcategory : subsubcategory.getSubCategories()) {
                           // add subsubsubcategory
                           if(subsubsubcategory.getRelevance() != null ){
                              oneLevel.add(subsubsubcategory);
                           }
                        }
                     }
                     // add subsubcategory
                     if(subsubcategory.getRelevance() != null ){
                        oneLevel.add(subsubcategory);
                     }
                  }
               }
               // add subcategory
               if(subcategory.getRelevance() != null ){
                  oneLevel.add(subcategory);
               }
            }
            //add category
            if(category.getRelevance() != null ){
               oneLevel.add(category);
            }
         }
      }
      Collections.sort(oneLevel);
      ArrayList<Category> top = new ArrayList<Category>();
      for(int i = 0; i < 5; i++){
         top.add(oneLevel.get(i));
      }
      return new Gson().toJson(top);
   }
   @RequestMapping(value = "/api/other-categories")
   public String getOthersCategoriesList() throws ParseException {
      String response = this.getcategoriesList();
      Category categoryTree = new Gson().fromJson(response, Category.class);

      ArrayList<Category> oneLevel = new ArrayList<Category>();

      for (Category category : categoryTree.getSubCategories()) {
         if(category.getSubCategories() != null){
            for (Category subcategory : category.getSubCategories()) {
               if(subcategory.getSubCategories() != null){
                  for (Category subsubcategory : subcategory.getSubCategories()) {
                     if(subsubcategory.getSubCategories() != null){
                        for (Category subsubsubcategory : subsubcategory.getSubCategories()) {
                           // add subsubsubcategory
                           if(subsubsubcategory.getRelevance() != null ){
                              oneLevel.add(subsubsubcategory);
                           }
                        }
                     }
                     // add subsubcategory
                     if(subsubcategory.getRelevance() != null ){
                        oneLevel.add(subsubcategory);
                     }
                  }
               }
               // add subcategory
               if(subcategory.getRelevance() != null ){
                  oneLevel.add(subcategory);
               }
            }
            //add category
            if(category.getRelevance() != null ){
               oneLevel.add(category);
            }
         }
      }
      Collections.sort(oneLevel);
      ArrayList<Category> others = new ArrayList<Category>();
      for(int i = 5; i < oneLevel.size(); i++){
         others.add(oneLevel.get(i));
      }
      return new Gson().toJson(others);
   }
}
