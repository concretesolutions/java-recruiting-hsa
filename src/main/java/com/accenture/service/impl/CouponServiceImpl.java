package com.accenture.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.client.ClientCoupon;
import com.accenture.dto.CouponDTO;
import com.accenture.exception.GenericNotFoundException;
import com.accenture.exception.ServiceException;
import com.accenture.service.CouponService;

import lombok.extern.log4j.Log4j2;

/**
 * 
 * @author
 *
 */
@Log4j2
@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private ClientCoupon clientCoupon;

	/**
	 * filtra cupones no expirados
	 */
	@Override
	public List<CouponDTO> getNotExpiredCoupons() throws ServiceException, GenericNotFoundException {
		log.debug("getNotExpiredCoupons");
		List<CouponDTO> list = this.clientCoupon.call();
		return list.stream().filter(c -> c.getExpiresAt().isAfter(LocalDate.now())).collect(Collectors.toList());
	}

}
