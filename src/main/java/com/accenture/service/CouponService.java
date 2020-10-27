package com.accenture.service;

import java.util.List;

import com.accenture.dto.CouponDTO;
import com.accenture.exception.GenericNotFoundException;
import com.accenture.exception.ServiceException;

public interface CouponService {

	List<CouponDTO> getNotExpiredCoupons() throws ServiceException, GenericNotFoundException;
}
