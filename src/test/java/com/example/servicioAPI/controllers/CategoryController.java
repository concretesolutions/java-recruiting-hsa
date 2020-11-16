package com.example.servicioAPI.controllers;

import com.example.servicioAPI.model.*;
import com.example.servicioAPI.services.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoriasService categoriasService;

    @GetMapping("/top5")
    public List<Category> mappingTop5() throws ParseException {
        Category category = this.categoriasService.consumirJSON();
        List<Category> categoryList = new ArrayList<Category>();
        categoryList= this.carruselTopFive(category);
        return categoryList;
    }

    @GetMapping("/lastlist")
    public List<Category> mappingLastList() throws ParseException {
        Category category = this.categoriasService.consumirJSON();
        List<Category> categoryList = new ArrayList<Category>();
        categoryList= this.carruselLastList(category);
        return categoryList;
    }

    private List<Category> carruselTopFive(Category category) {
        List<Category> listcategory = new ArrayList<Category>();
        List<Category> top5 = new ArrayList<Category>();
        listcategory = this.recursivaWithRelevance(category,listcategory);
        Collections.sort(listcategory, Collections.reverseOrder());
        for(int i=0;i<5;i++){
            top5.add(listcategory.get(i));
        }
        return top5;
    }
    private List<Category> carruselLastList(Category category) {
        List<Category> listcategory = new ArrayList<Category>();
        List<Category> lastList = new ArrayList<Category>();
        List<Category> listcategoryNoRelevance = new ArrayList<Category>();
        listcategory = this.recursivaWithRelevance(category,listcategory);
        listcategoryNoRelevance = this.recursivaWithoutRelevance(category,listcategoryNoRelevance, false);
        Collections.sort(listcategory, Collections.reverseOrder());
        for(int i=5;i<listcategory.size();i++){
            lastList.add(listcategory.get(i));
        }
        for(int i=0;i<listcategoryNoRelevance.size();i++){
            lastList.add(listcategoryNoRelevance.get(i));
        }
        return lastList;
    }

    private List<Category> recursivaWithRelevance(Category category, List<Category> listcategory) {
        if(category.getSubcategories()!=null) {
            for (Category categoria : category.getSubcategories()) {
                if (category.getSmallImageUrl() != null) {
                    category.setImage(category.getSmallImageUrl());
                    category.setSmallImageUrl(null);
                    category.setMediumImageUrl(null);
                    category.setLargeImageUrl(null);
                } else if (category.getMediumImageUrl() != null) {
                    category.setImage(category.getMediumImageUrl());
                    category.setMediumImageUrl(null);
                    category.setLargeImageUrl(null);
                } else if (category.getLargeImageUrl() != null) {
                    category.setImage(category.getLargeImageUrl());
                    category.setLargeImageUrl(null);
                } else {
                    category.setSmallImageUrl(null);
                    category.setMediumImageUrl(null);
                    category.setLargeImageUrl(null);
                }
            }
        }
        if (category.getSmallImageUrl() != null) {
            category.setImage(category.getSmallImageUrl());
            category.setSmallImageUrl(null);
            category.setMediumImageUrl(null);
            category.setLargeImageUrl(null);
        } else if (category.getMediumImageUrl() != null) {
            category.setImage(category.getMediumImageUrl());
            category.setMediumImageUrl(null);
            category.setLargeImageUrl(null);
        } else if (category.getLargeImageUrl() != null) {
            category.setImage(category.getLargeImageUrl());
            category.setLargeImageUrl(null);
        }else {
            category.setSmallImageUrl(null);
            category.setMediumImageUrl(null);
            category.setLargeImageUrl(null);
        }
        if (category.getRelevance() != null) {
            listcategory.add(category);
        }
        if (category.getSubcategories() != null) {
            for (Category categoria : category.getSubcategories()) {
                this.recursivaWithRelevance(categoria, listcategory);
            }
        }

        return listcategory;
    }
    private List<Category> recursivaWithoutRelevance(Category category, List<Category> listcategoryNoRelevance, Boolean marca) {
        if(category.getSubcategories()!=null) {
            for (Category categoria : category.getSubcategories()) {
                if (category.getSmallImageUrl() != null) {
                    category.setImage(category.getSmallImageUrl());
                    category.setSmallImageUrl(null);
                    category.setMediumImageUrl(null);
                    category.setLargeImageUrl(null);
                } else if (category.getMediumImageUrl() != null) {
                    category.setImage(category.getMediumImageUrl());
                    category.setMediumImageUrl(null);
                    category.setLargeImageUrl(null);
                } else if (category.getLargeImageUrl() != null) {
                    category.setImage(category.getLargeImageUrl());
                    category.setLargeImageUrl(null);
                } else {
                    category.setSmallImageUrl(null);
                    category.setMediumImageUrl(null);
                    category.setLargeImageUrl(null);
                }
            }
        }
        if (category.getSmallImageUrl() != null) {
            category.setImage(category.getSmallImageUrl());
            category.setSmallImageUrl(null);
            category.setMediumImageUrl(null);
            category.setLargeImageUrl(null);
        } else if (category.getMediumImageUrl() != null) {
            category.setImage(category.getMediumImageUrl());
            category.setMediumImageUrl(null);
            category.setLargeImageUrl(null);
        } else if (category.getLargeImageUrl() != null) {
            category.setImage(category.getLargeImageUrl());
            category.setLargeImageUrl(null);
        }else {
            category.setSmallImageUrl(null);
            category.setMediumImageUrl(null);
            category.setLargeImageUrl(null);
        }
        if (category.getRelevance() == null) {
            listcategoryNoRelevance.add(category);
        }
        if (category.getSubcategories() != null) {
            for (Category categoria : category.getSubcategories()) {
                this.recursivaWithoutRelevance(categoria, listcategoryNoRelevance, true);
            }
        }
        return listcategoryNoRelevance;
    }

}
