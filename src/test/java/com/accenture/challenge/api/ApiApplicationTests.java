package com.accenture.challenge.api;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.challenge.api.dto.CategoryDTO;
import com.accenture.challenge.api.dto.SubCategoryDTO;
import com.accenture.challenge.api.exceptions.CustomNotFoundException;
import com.accenture.challenge.api.exceptions.ProxyException;
import com.accenture.challenge.api.models.Coupon;
import com.accenture.challenge.api.proxy.ProxyService;
import com.accenture.challenge.api.utils.ImageType;
import com.accenture.challenge.api.utils.Utils;

@SpringBootTest
@RunWith(SpringRunner.class)
class ApiApplicationTests {
	
	@Autowired
	private ProxyService service;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void getTopFiveCategoriesAllImages() throws CustomNotFoundException {
		
		try {
			
			List<CategoryDTO> categories = this.service.getTopCategories(5, ImageType.all.name());
			
			assertTrue(categories.size() == 5);
			
				for (CategoryDTO categoryDTO : categories) {
					
					for (SubCategoryDTO subCategoryDTO : categoryDTO.getSubCategories()) {
						
							assertTrue(subCategoryDTO.getCategoryImages().getLargeImageUrl() != null && subCategoryDTO.getCategoryImages().getMediumImageUrl() != null && subCategoryDTO.getCategoryImages().getSmallImageUrl() != null);
					}
					
				}
				
			
		} catch (ProxyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getTopFiveCategoriesOnlySmallImages() throws CustomNotFoundException {
		
		try {
			
			List<CategoryDTO> categories = this.service.getTopCategories(5, ImageType.small.name());
			assertTrue(categories.size() == 5);
			for (CategoryDTO categoryDTO : categories) {
				
				for (SubCategoryDTO subCategoryDTO : categoryDTO.getSubCategories()) {
					
						assertTrue(subCategoryDTO.getCategoryImages().getLargeImageUrl() == null && subCategoryDTO.getCategoryImages().getMediumImageUrl() == null && subCategoryDTO.getCategoryImages().getSmallImageUrl() != null);
				}
				
			}
			
		} catch (ProxyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getCategoriesRemainderAllIMages() throws CustomNotFoundException {
		
		try {
			
			List<CategoryDTO> categories = this.service.getCategoriesRemainder(5, ImageType.all.name());
			
			assertTrue(categories.size() == 3);
			
				for (CategoryDTO categoryDTO : categories) {
					
					for (SubCategoryDTO subCategoryDTO : categoryDTO.getSubCategories()) {
						
							assertTrue(subCategoryDTO.getCategoryImages().getLargeImageUrl() != null && subCategoryDTO.getCategoryImages().getMediumImageUrl() != null && subCategoryDTO.getCategoryImages().getSmallImageUrl() != null);
					}
					
				}
				
			
		} catch (ProxyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getCategoriesRemainderOnlySmallIMages() throws CustomNotFoundException {
		
		try {
			
			List<CategoryDTO> categories = this.service.getCategoriesRemainder(5, ImageType.small.name());
			
			assertTrue(categories.size() == 3);
			
				for (CategoryDTO categoryDTO : categories) {
					
					for (SubCategoryDTO subCategoryDTO : categoryDTO.getSubCategories()) {
						
							assertTrue(subCategoryDTO.getCategoryImages().getLargeImageUrl() == null && subCategoryDTO.getCategoryImages().getMediumImageUrl() == null && subCategoryDTO.getCategoryImages().getSmallImageUrl() != null);
					}
					
				}
				
			
		} catch (ProxyException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void getExpiredCoupons() throws CustomNotFoundException {
		
		try {
			
			List<Coupon> categories = this.service.getCoupons(true);
			
			categories.stream().forEach(c -> {
				
				    assertTrue(Utils.isExpireDate( Utils.getDateFromString(c.getExpiresAt()))); 
			});
				
			
		} catch (ProxyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getNotExpiredCoupons() throws CustomNotFoundException {
		
		try {
			
			List<Coupon> categories = this.service.getCoupons(false);
			
			categories.stream().forEach(c -> {
				
				    assertFalse(Utils.isExpireDate( Utils.getDateFromString(c.getExpiresAt()))); 
			});
				
			
		} catch (ProxyException e) {
			e.printStackTrace();
		}
	}


}
