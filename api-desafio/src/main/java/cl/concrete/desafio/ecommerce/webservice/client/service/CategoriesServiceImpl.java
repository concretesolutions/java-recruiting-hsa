package cl.concrete.desafio.ecommerce.webservice.client.service;

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
	
	private CategoryDto categoryDto;
	
	@Override
	public List<Category> findAll() {
		return ResourceTransformer.transformDtosToCategory(this.categoryDto);
	}
	
	/**
	 * Execute the call each "${categories.refresh.time}" milliseconds
	 * to refresh the cached list
	 */
	@Scheduled(fixedRateString = "${categories.refresh.time}")
	public void refreshData() {
		this.categoryDto = null;
		this.categoryDto = this.client.findAll();
	}

}
