package com.consultas.demo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.consultas.demo.dto.CategoryResponse;
import com.consultas.demo.dto.Subcategory;
import com.consultas.demo.dto.SubcategoryLv2;

@Service
public class CategorieSeviceImpl implements CategoryService{
	
	private CategoryServiceRestClient categoryServiceRestClient;
	
	static int NUMBER_TOP_CATEGORIES =5;
	
	  @Autowired
	  public CategorieSeviceImpl(final CategoryServiceRestClient categoryServiceRestClient) {
	    this.categoryServiceRestClient = categoryServiceRestClient;
	  }

	@Override
	@Cacheable("categorieTop5")
	public CategoryResponse getTopCategories() {
		CategoryResponse topCategories = new CategoryResponse();
		
		topCategories = categoryServiceRestClient.getCategories();
		
		//ordena subcategorias por atributo Relevance
        topCategories.getSubcategories().stream()
		.forEach(x -> x.setSubcategories(sortCategoriesByRelevance(x.getSubcategories())));
		
		return topCategories;
	}
	
  private List<SubcategoryLv2> sortCategoriesByRelevance(List<SubcategoryLv2> list)
  {
  	List<SubcategoryLv2> categoryLv2 = new ArrayList<SubcategoryLv2>();
  	try {
  		categoryLv2 = list.stream().sorted(Comparator.comparingInt(SubcategoryLv2::getRelevance)).collect(Collectors.toList());
  			categoryLv2 = categoryLv2.stream().limit(NUMBER_TOP_CATEGORIES).collect(Collectors.toList());
  	}
  	catch(Exception e)
  	{
  		e.printStackTrace();
  	}
  	return categoryLv2;
  	
  }

	@Override
	@Cacheable("RemainingCategories")
	public CategoryResponse getRemainingCategories() {

		 CategoryResponse listAllCategories = categoryServiceRestClient.getCategories();
		 CategoryResponse listRemainingCategories = new CategoryResponse();

        	CategoryResponse topCategories =  getTopCategories();
           
        	listRemainingCategories = removeTopcategories(topCategories,listAllCategories);

        return listRemainingCategories;
		
	}

	private CategoryResponse removeTopcategories(CategoryResponse topCategories, CategoryResponse listAllCategories) {
   	 for(Subcategory subcategory : topCategories.getSubcategories())
   	 {
   		 for(SubcategoryLv2 subcategoryLv2 : subcategory.getSubcategories())
   		 {
   			 listAllCategories.getSubcategories().stream().forEach(x -> x.getSubcategories().removeIf(y-> y.getId().equals(subcategoryLv2.getId())));
   			 
   		 }
   			 
   	 }
		return listAllCategories;
	}

}
