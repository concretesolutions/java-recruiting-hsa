package com.concrete.categoria.service;

import java.util.Collection;

import com.concrete.categoria.dto.CategoryThreeDTO;
import com.concrete.categoria.dto.CouponDTO;

public interface ConsumeService {
	

	public CategoryThreeDTO getCategories() ;
	public Collection<CouponDTO> getCoupons();;

}
