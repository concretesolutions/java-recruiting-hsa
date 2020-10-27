package com.accenture.challenge.api.proxy;

import java.util.List;

import com.accenture.challenge.api.dto.CategoryDTO;
import com.accenture.challenge.api.exceptions.CouponServiceException;
import com.accenture.challenge.api.exceptions.CustomNotFoundException;
import com.accenture.challenge.api.exceptions.ProxyException;

public interface ICategoriesService {
	
	List<CategoryDTO> getTopCategories(int top, String imageType)  throws CouponServiceException, ProxyException, CustomNotFoundException;
	List<CategoryDTO> getCategoriesRemainder(int top, String imageType) throws CouponServiceException, ProxyException, CustomNotFoundException;

}
