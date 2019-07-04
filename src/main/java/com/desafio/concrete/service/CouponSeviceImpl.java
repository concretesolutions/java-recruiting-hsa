package com.desafio.concrete.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.desafio.concrete.model.CouponResponse;

@Service
public class CouponSeviceImpl implements CouponService {

	private CouponsServiceRestClient couponsServiceRestClient;

	@Autowired
	public CouponSeviceImpl(final CouponsServiceRestClient couponsServiceRestClient) {
		this.couponsServiceRestClient = couponsServiceRestClient;
	}

	@Override
	@Cacheable("CuponsValid")
	public List<CouponResponse> getValidCoupons() {

		List<CouponResponse> listCoupons = new ArrayList<CouponResponse>();
		listCoupons = couponsServiceRestClient.getCoupons().stream().filter(x -> validExpiredDate(x.getExpiresAt()))
				.collect(Collectors.toList());
		return listCoupons;
	}

	private boolean validExpiredDate(String expiredDate) {
		boolean expiredDateFlag = false;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {

			String nowDateString = format.format(new Date());

			Date date = format.parse(expiredDate);
			Date now = format.parse(nowDateString);

			expiredDateFlag = date.after(now);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return expiredDateFlag;

	}

}
