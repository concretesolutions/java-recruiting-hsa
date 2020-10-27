package com.accenture.challenge.api.proxy;

import java.util.List;

import com.accenture.challenge.api.exceptions.CouponServiceException;
import com.accenture.challenge.api.exceptions.CustomNotFoundException;
import com.accenture.challenge.api.exceptions.ProxyException;
import com.accenture.challenge.api.models.Coupon;

public interface ICouponsService {
	
	
	List<Coupon> getCoupons(boolean expired) throws CouponServiceException, ProxyException, CustomNotFoundException;

}
