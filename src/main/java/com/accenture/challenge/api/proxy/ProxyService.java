package com.accenture.challenge.api.proxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accenture.challenge.api.business.service.CategoriesService;
import com.accenture.challenge.api.business.service.CouponsService;
import com.accenture.challenge.api.dto.CategoryDTO;
import com.accenture.challenge.api.exceptions.CouponServiceException;
import com.accenture.challenge.api.exceptions.CustomNotFoundException;
import com.accenture.challenge.api.exceptions.ProxyException;
import com.accenture.challenge.api.models.Coupon;

@Component
public class ProxyService implements ICategoriesService, ICouponsService {

	@Autowired
	private CategoriesService categoriesService;
	
	@Autowired
	private CouponsService couponsService;
	
	@Override
	public List<CategoryDTO> getTopCategories(int top, String imageType) throws ProxyException, CustomNotFoundException {
		
		List<CategoryDTO> categoryDTOs = null;
		
		try {
			
			categoryDTOs = this.categoriesService.getTopCategories(top, imageType);
			
		} catch (CouponServiceException e) {
			
			throw new ProxyException(e.getMessage(), e);
		}
		return categoryDTOs;
	}

	@Override
	public List<CategoryDTO> getCategoriesRemainder(int top, String imageType) throws ProxyException, CustomNotFoundException{
		
		List<CategoryDTO> categoryDTOs = null;

			try {
				categoryDTOs = this.categoriesService.getCategoriesRemainder(top, imageType);
			} catch (CouponServiceException e) {
				
				throw new ProxyException(e.getMessage(), e);
			}
		
			return categoryDTOs;
	}

	@Override
	public List<Coupon> getCoupons(boolean expired) throws ProxyException, CustomNotFoundException {
		
		List<Coupon> coupons = new ArrayList<Coupon>();
		
		try {
			
			coupons = this.couponsService.getCoupons(expired);
			
		} catch (CouponServiceException e) {
			
			throw new ProxyException(e.getMessage(), e);
		}
		
		return coupons;
		
	}

}
