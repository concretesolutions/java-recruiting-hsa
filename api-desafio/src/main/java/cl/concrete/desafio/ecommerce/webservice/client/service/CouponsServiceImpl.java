package cl.concrete.desafio.ecommerce.webservice.client.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cl.concrete.desafio.ecommerce.utils.ResourceTransformer;
import cl.concrete.desafio.ecommerce.webservice.client.model.Coupon;
import cl.concrete.desafio.ecommerce.webservice.client.model.CouponDto;
import cl.concrete.desafio.ecommerce.webservice.client.rest.CouponsRestClient;

@Service
public class CouponsServiceImpl implements CouponsService {

	@Autowired
	private CouponsRestClient client;
	
	private List<Coupon> coupons;
	
	/**
	 * Call the cached list into the service
	 */
	@Override
	public List<Coupon> findAll() {
		return this.coupons;
	}
	
	@Override
	public List<Coupon> findCurrents() {
		List<Coupon> currentCoupons = new ArrayList<Coupon>();
		for(Coupon coupon:this.coupons) {
			if(coupon.getExpiresAt().getTime() >= System.currentTimeMillis()) {
				currentCoupons.add(coupon);
			}
		}
		return currentCoupons;
	}

	
	/**
	 * Execute the call each "${coupons.refresh.time}" milliseconds
	 * to refresh the cached list
	 */
	@Scheduled(fixedRateString = "${coupons.refresh.time}")
	public void refreshData() {
		try {
			List<CouponDto> tmp = this.client.findAll();
			if(tmp != null && !tmp.isEmpty()) {
				if(this.coupons != null ) {
					this.coupons.clear();
				}
				this.coupons = ResourceTransformer.transformDtosToCoupon(tmp);
			}
		} catch (ParseException e) {
			// TODO Create Logger
		}
	}

}
