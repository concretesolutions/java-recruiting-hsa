package cl.concretesolutions.mobileapp.api.category.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.concretesolutions.mobileapp.api.category.CategoryClient;
import cl.concretesolutions.mobileapp.api.category.CategoryDto;
import cl.concretesolutions.mobileapp.api.category.CategoryTree;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryClient client;
	
	/**
	 * @return the list of all categories
	 */
	public List<CategoryDto> getCategories() {
		CategoryTree categories =  client.getCategories();
		List<CategoryDto> cat = new ArrayList<CategoryDto>();
		setParentCategory(categories.getSubcategories(), categories.getId());
		setCategoryProposal(categories.getSubcategories(), cat);
		return cat;
	}
	
	
	/**
	 * @param numCategories Number of top N categories to return
	 * @return List all categories, categories with isTop = true are the N top, other isTop is false
	 */
	public List<CategoryDto> getTopNCategories(int numCategories) {
		List<CategoryDto> categories = getCategories();
		Collections.sort(categories);
		
		if (categories.size() < numCategories) {
			numCategories = categories.size();
		}
		
		for(int x = 0; x < numCategories; x++) {
			categories.get(x).setTop(true);
		}
		return categories;
	}
	
	
	/**
	 * @return all categories in original format tree
	 */
	public CategoryTree getOriginalCategories() {
		return client.getCategories();
	}
	
	
	/**
	 * Makes a new category structure more readable
	 * @param categories List of subcategories 
	 * @param catBase list with the new structure of categories
	 */
	private void setCategoryProposal(List<CategoryTree> categories, List<CategoryDto> catBase) {
		if (categories == null) return;
		categories.forEach( (CategoryTree cat) -> { 			
			if (cat.getRelevance() > 0 ) {
				CategoryDto base = new CategoryDto();
				base.setId(cat.getId());
				base.setName(cat.getName());
				base.setRelevance(cat.getRelevance());
				base.setIconImageUrl(cat.getIconImageUrl());
				base.setSmallImageUrl(cat.getSmallImageUrl());
				base.setParentCategory(cat.getParentCategory());
				catBase.add(base);
			}
			
			if( !cat.getSubcategories().isEmpty()) { 
				setCategoryProposal(cat.getSubcategories(), catBase);
			}
		});
	}
	
	
	/**
	 * Set the parent category
	 * @param categories List of subcategories 
	 * @param parent the parent category Id
	 */
	private void setParentCategory(List<CategoryTree> categories, String parent) {
		if (categories == null) return;
		categories.forEach( (CategoryTree cat) -> {
			cat.setParentCategory(parent); 
			if( !cat.getSubcategories().isEmpty()) { 
				setParentCategory(cat.getSubcategories(), cat.getId() );
			}
		});
	}
}
