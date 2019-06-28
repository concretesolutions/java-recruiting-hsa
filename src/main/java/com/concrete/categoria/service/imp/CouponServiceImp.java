package com.concrete.categoria.service.imp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.concrete.categoria.dto.CouponDTO;
import com.concrete.categoria.service.ConsumeService;
import com.concrete.categoria.service.CouponService;
import com.google.gson.Gson;


@Component
public class CouponServiceImp implements CouponService {

	@Autowired
	ConsumeService consumeService;
	

	@Override
	public Collection<CouponDTO> getCoupons() {
		return consumeService.getCoupons();
	}
	
	@Override
	public Collection<CouponDTO> getNotExpiredCoupons() {
		
		Collection<CouponDTO>  collectionCoupons = consumeService.getCoupons();
		Collection<CouponDTO> notExpiredCoupons = getNotExpiredCoupons(collectionCoupons);
		
		return notExpiredCoupons;
	}

	public Collection<CouponDTO> getNotExpiredCoupons(Collection<CouponDTO> collectionCoupons) {
		CouponDTO[] arrayCoupons = collectionCoupons.toArray(new CouponDTO[collectionCoupons.size()]);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		
		arrayCoupons =Arrays.stream(arrayCoupons).filter(s -> {
			try {
				return sdf.parse(s.getExpiresAt()).getTime() > today.getTime();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		} ).toArray(CouponDTO[]::new);;
		
		Collection<CouponDTO> notExpiredCoupons = new ArrayList<CouponDTO>(Arrays.asList(arrayCoupons));
		return notExpiredCoupons;
	}



	


}
