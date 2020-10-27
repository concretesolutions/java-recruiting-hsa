package com.accenture.challenge.api.business.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.challenge.api.dto.CategoryDTO;
import com.accenture.challenge.api.dto.CategoryImagesDTO;
import com.accenture.challenge.api.dto.SubCategoryDTO;
import com.accenture.challenge.api.exceptions.CouponServiceException;
import com.accenture.challenge.api.exceptions.CustomNotFoundException;
import com.accenture.challenge.api.models.Categories;
import com.accenture.challenge.api.models.CategoryThree;
import com.accenture.challenge.api.models.SubCategoryLevel2;
import com.accenture.challenge.api.models.SubCategoryLevel3;
import com.accenture.challenge.api.models.SubCategoryLevel4;
import com.accenture.challenge.api.proxy.ICategoriesService;
import com.accenture.challenge.api.utils.CategoryComparator;
import com.accenture.challenge.api.utils.ImageType;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoriesService implements ICategoriesService {
	
	/**
	 * Obtiene un listado de cupones desde una API externa
	 * @return
	 * @throws CouponServiceException
	 */
	private CategoryThree getCategories() throws CouponServiceException, CustomNotFoundException {
		
		RestTemplate restTemplate = new RestTemplate();
		CategoryThree categoryThree = null;
		try {
			
			ResponseEntity<CategoryThree> response = restTemplate.exchange("https://cs-hsa-api-categories.herokuapp.com/categories", HttpMethod.GET, null, CategoryThree.class);
			
			if (response.getStatusCode() == HttpStatus.OK) {
				
				categoryThree = response.getBody();
				
			} else {
				log.error("HttpStatus Error: CategoriesService:getCategories(), error : " + response.getStatusCode().toString());
				if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
					throw new CustomNotFoundException(HttpStatus.NOT_FOUND.toString());
				}
			}
			
		} catch (Exception ex) {
			log.error("Service error: CategoriesService:getCategories(), error : " + ex.getMessage());
			throw new CouponServiceException("CategoriesService Error", ex);
			
		}
		
		return categoryThree;
	}
	
	/**
	 * Transforma el modelo del servicio en clases DTO para simplificar la estructura.
	 * 
	 * 	Category
	 * 		SubCategory	
	 * 			details
	 * @return
	 * @throws CouponServiceException 
	 * @throws CustomNotFoundException 
	 */
	private List<CategoryDTO> getCategoriesDTO(String imageType) throws CouponServiceException, CustomNotFoundException {
		
		 CategoryThree category = this.getCategories();
		 List<CategoryDTO> categoryDTOs = new ArrayList<>();
		 List<SubCategoryDTO> subCategoryDTOs = new ArrayList<>();
		 List<SubCategoryDTO> subCategory2DTOs = new ArrayList<>();
		 
		 
		 for (Categories categories : category.getSubcategories()) {

			 for (SubCategoryLevel2 subCategoryLevel2 : categories.getSubcategories()) {
				 
				 CategoryDTO categoryDTO = new CategoryDTO();
				 	
				 categoryDTO.setId(subCategoryLevel2.getId());
				 categoryDTO.setName(subCategoryLevel2.getName());
				 categoryDTO.setRelevance(subCategoryLevel2.getRelevance());  
				 categoryDTO.setIconImageUrl(subCategoryLevel2.getIconImageUrl());
				 
				 	for (SubCategoryLevel3 subCategoryLevel3 : subCategoryLevel2.getSubcategories()) {
				 		
				 		SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
				 		
				 		subCategoryDTO.setId(subCategoryLevel3.getId());
				 		subCategoryDTO.setName(subCategoryLevel3.getName());
				 		subCategoryDTO.setRelevance( subCategoryLevel3.getRelevance());
				 			CategoryImagesDTO categoryImagesDTO = new CategoryImagesDTO();
				 			if (imageType.equals(ImageType.all.name())) {
				 				categoryImagesDTO.setLargeImageUrl(subCategoryLevel3.getLargeImageUrl());
				 				categoryImagesDTO.setMediumImageUrl(subCategoryLevel3.getMediumImageUrl());
				 				categoryImagesDTO.setSmallImageUrl(subCategoryLevel3.getSmallImageUrl());
				 			} else if (imageType.equals(ImageType.large.name())) {
				 				categoryImagesDTO.setLargeImageUrl(subCategoryLevel3.getLargeImageUrl());
				 			} else if (imageType.equals(ImageType.medium.name())) {
				 				categoryImagesDTO.setMediumImageUrl(subCategoryLevel3.getMediumImageUrl());
				 			} else if (imageType.equals(ImageType.small.name())) {
				 				categoryImagesDTO.setSmallImageUrl(subCategoryLevel3.getSmallImageUrl());
				 			}
				 		subCategoryDTO.setCategoryImages(categoryImagesDTO);
				 		
				 		
				 			for (SubCategoryLevel4 subCategoryLevel4 : subCategoryLevel3.getSubcategories()) {
				 				
				 				SubCategoryDTO subCategory2DTO = new SubCategoryDTO();
				 				
				 					subCategory2DTO.setId(subCategoryLevel4.getId());
				 					subCategory2DTO.setName(subCategoryLevel4.getName());
				 					subCategory2DTO.setRelevance(subCategoryLevel4.getRelevance());
				 				
				 				subCategory2DTOs.add(subCategory2DTO);
				 			}
				 			
				 			subCategoryDTO.setDetails(new ArrayList<SubCategoryDTO>());
				 			subCategoryDTO.getDetails().addAll(subCategory2DTOs);
				 			subCategoryDTOs.add(subCategoryDTO);
				 	}
				 
				 categoryDTO.setSubCategories(new ArrayList<SubCategoryDTO>());
				 categoryDTO.getSubCategories().addAll(subCategoryDTOs);	
				 categoryDTOs.add(categoryDTO);
				 
			 }
		 }
		 
		 return categoryDTOs;
	}

	@Override
	public List<CategoryDTO> getTopCategories(int top, String imageType) throws CouponServiceException, CustomNotFoundException {
		List<CategoryDTO> categoryDTOs = this.getCategoriesDTO(imageType);
		
		Collections.sort(categoryDTOs, CategoryComparator.getCategoryComparatorByRelevance());
		 if (categoryDTOs.size() > top) {
			 return categoryDTOs.subList(0, top); 
		 } 
		 return categoryDTOs.subList(0, categoryDTOs.size()-1);
		
	}

	@Override
	public List<CategoryDTO> getCategoriesRemainder(int top, String imageType) throws CouponServiceException, CustomNotFoundException {
		List<CategoryDTO> categoryDTOs = this.getCategoriesDTO(imageType);
		Collections.sort(categoryDTOs, CategoryComparator.getCategoryComparatorByRelevance());
		return categoryDTOs.subList(top, categoryDTOs.size()-1);
	}

}
