package cl.concrete.desafio.ecommerce.webservice.client.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cl.concrete.desafio.ecommerce.utils.ResourceTransformer;
import cl.concrete.desafio.ecommerce.webservice.client.model.Category;
import cl.concrete.desafio.ecommerce.webservice.client.model.CategoryDto;
import cl.concrete.desafio.ecommerce.webservice.client.rest.CategoriesRestClient;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	private CategoriesRestClient client;
	
	private List<Category> categories;
	
	@Override
	public List<Category> findAll() {
		return this.categories;
	}
	
	@Override
	public List<Category> findTopCategories() {
		Collections.sort(this.categories, Collections.reverseOrder());
		final List<Category> topCategories = new ArrayList<Category>();
		for(short top = 0; top < 5; top++) {
			if(this.categories.get(top).getRelevance() > 0) {
				topCategories.add(this.categories.get(top));
			}
		}
		return topCategories;
	}
	
	@Override
	public List<Category> findNoTopCategories() {
		Collections.sort(this.categories, Collections.reverseOrder());
		final List<Category> noTopCategories = new ArrayList<Category>();
		for(int noTop = 5; noTop < this.categories.size() ; noTop++) {
			if(this.categories.get(noTop).getRelevance() > 0) {
				noTopCategories.add(this.categories.get(noTop));
			}
		}
		return noTopCategories;
	}
	
	/**
	 * Execute the call each "${categories.refresh.time}" milliseconds
	 * to refresh the cached list
	 */
	@Scheduled(fixedRateString = "${categories.refresh.time}")
	public void refreshData() {
		final CategoryDto categoryDto = this.client.findAll();
		if(this.categories != null) {
			this.categories.clear();
		}
		this.categories = ResourceTransformer.transformDtosToCategory(categoryDto);
	}

}
