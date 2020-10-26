package cl.mobile.bff.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.mobile.bff.client.interfaces.CategoryClient;
import cl.mobile.bff.domain.CategoryClientResponse;
import cl.mobile.bff.exception.ApiInternalServerException;
import cl.mobile.bff.service.interfaces.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	@Autowired
	private CategoryClient categoryClient;

	@Override
	public List<CategoryClientResponse> getTopFive() {
		
		List<CategoryClientResponse> topFiveCategories = new ArrayList<>();
		List<CategoryClientResponse> categoriesList = new ArrayList<>();
		
		try {
			CategoryClientResponse categories = categoryClient.getCategories();
			
			if (categories != null) {
				List<CategoryClientResponse> aux = new ArrayList<>();
				aux.add(categories);
				
				convertToList(aux, categoriesList);
				
				topFiveCategories = getTopFive(categoriesList);
			}
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new ApiInternalServerException(e);
		}
		
		return topFiveCategories;
	}
	
	private List<CategoryClientResponse> getTopFive(List<CategoryClientResponse> categories) {
		List<CategoryClientResponse> topFiveCategories = new ArrayList<>();
		
		try {
			
			List<CategoryClientResponse> sortedList = categories.stream()
					.sorted(Comparator.comparingInt(CategoryClientResponse::getRelevance))
					.collect(Collectors.toList());
			
			int index = sortedList.size() - 1;
			int max = 0;
			
			if (sortedList.size() < 5) {
				max = sortedList.size();
			} else {
				max = 5;
			}
			
			for (int i = 0 ; i < max ; i++) {
				topFiveCategories.add(sortedList.get(index));
				index--;
			}
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new ApiInternalServerException(e);
		}
		
		return topFiveCategories;
	}
	
	private List<CategoryClientResponse> getRemain(List<CategoryClientResponse> categories) {
		List<CategoryClientResponse> sortedList = new ArrayList<>();
		try {
			sortedList = categories.stream()
					.sorted(Comparator.comparingInt(CategoryClientResponse::getRelevance))
					.collect(Collectors.toList());
			
			int index = sortedList.size() - 1;
			for (int i = 0 ; i < 5 ; i++) {
				if (index == 0) {
					break;
				}
				sortedList.remove(index);
				index--;
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new ApiInternalServerException(e);
		}
		
		return sortedList;
	}
	
	
	private List<CategoryClientResponse> convertToList(List<CategoryClientResponse> categoriesIn, List<CategoryClientResponse> categoriesFinal) {
		
		try {
			for (CategoryClientResponse category : categoriesIn) {
				CategoryClientResponse obj = new CategoryClientResponse();
				obj.setId(category.getId());
				obj.setName(category.getName());
				obj.setRelevance(category.getRelevance());
				obj.setSmallImageUrl(category.getSmallImageUrl());
				obj.setIconImageUrl(category.getIconImageUrl());
				
				categoriesFinal.add(obj);
				
				if (category.getSubcategories() != null && !category.getSubcategories().isEmpty()) {
					convertToList(category.getSubcategories(), categoriesFinal);
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new ApiInternalServerException(e);
		}
		
		return categoriesFinal;
	}

	@Override
	public List<CategoryClientResponse> getRemain() {
		List<CategoryClientResponse> remainCategories = new ArrayList<>();
		List<CategoryClientResponse> categoriesList = new ArrayList<>();
		
		try {
			CategoryClientResponse categories = categoryClient.getCategories();
			
			if (categories != null) {
				List<CategoryClientResponse> aux = new ArrayList<>();
				aux.add(categories);
				
				convertToList(aux, categoriesList);
				
				remainCategories = getRemain(categoriesList);
			}
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new ApiInternalServerException(e);
		}
		
		return remainCategories;
	}
}
