package com.concrete.challenge.service;

import com.concrete.challenge.api.Endpoints;
import com.concrete.challenge.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CategoryService {

    @Autowired
    RestTemplate restTemplate;

    public List<Object> findTopFiveCategories(){

        List<Object> topFiveCategories = new ArrayList<>();

        try{

            RootCategory rootCategory = restTemplate.getForObject(
                    Endpoints.CATEGORIES_ENDPOINT, RootCategory.class);
            if(rootCategory!=null){
                TreeMap<Integer, Object> tmap = generateTreeForSort(rootCategory);

                generateTopoFiveList(topFiveCategories, tmap);
            }

        }catch (RestClientException ex){
            //TODO lack include log for this
        }

        return topFiveCategories;
    }

    public List<Object> findCategoriesWithoutTopFive(){

        List<Object> topFiveCategories = new ArrayList<>();

        try{

            RootCategory rootCategory = restTemplate.getForObject(
                    Endpoints.CATEGORIES_ENDPOINT, RootCategory.class);
            if(rootCategory!=null){
                TreeMap<Integer, Object> tmap = generateTreeForSort(rootCategory);
                if(tmap.size()>5) {
                    generateCategoriesWithoutTopFive(topFiveCategories, tmap);
                }
            }

        }catch (RestClientException ex){
            //TODO lack include log for this
        }

        return topFiveCategories;
    }


    private void generateCategoriesWithoutTopFive(List<Object> topFiveCategories, TreeMap<Integer, Object> tmap) {
        Set set = tmap.entrySet();
        Iterator iterator = set.iterator();

        int countTopFive = 5;

        while(countTopFive>0) {
            iterator.next();
            countTopFive--;
        }

        do{
            Map.Entry mentry = (Map.Entry)iterator.next();
            topFiveCategories.add(mentry.getValue());
        }
        while(iterator.hasNext());

    }

    private void generateTopoFiveList(List<Object> topFiveCategories, TreeMap<Integer, Object> tmap) {
        Set set = tmap.entrySet();
        Iterator iterator = set.iterator();
        int countTopFive = 5;
        while(iterator.hasNext() && countTopFive>0) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            topFiveCategories.add(mentry.getValue());
            countTopFive--;
        }
    }

    private TreeMap<Integer, Object> generateTreeForSort(RootCategory rootCategory) {
        TreeMap<Integer, Object> tmap =
                new TreeMap<>(Collections.reverseOrder());

        for(Category category : rootCategory.getSubcategories()){
            Category category1 = new Category(category.getId(), category.getName(), category.getRelevance(), null);

            if(category1.getRelevance()!=null){
                tmap.put(category1.getRelevance(), category1);
            }

            for(Subcategory2 subcategory2 : category.getSubcategories()){
                Category category2 = new Category(subcategory2.getId(), subcategory2.getName(), subcategory2.getRelevance(), null);

                if(subcategory2.getRelevance()!=null) {
                    tmap.put(subcategory2.getRelevance(), category2);
                }
                for(Subcategory3 subcategory3 : subcategory2.getSubcategories()){

                    if(subcategory3.getRelevance()!=null) {
                        tmap.put(subcategory3.getRelevance(), subcategory3);
                    }
                    for(Subcategory4 subcategory4 : subcategory3.getSubcategories()){
                        Category category4 = new Category(subcategory4.getId(), subcategory4.getName(), subcategory4.getRelevance(), null);
                        if(category4.getRelevance()!=null) {
                            tmap.put(category4.getRelevance(), category4);
                        }
                    }

                }

            }
        }
        return tmap;
    }


}
