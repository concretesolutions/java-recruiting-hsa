package cl.concrete.desafio.ecommerce.webservice.client.service;

import java.text.ParseException;
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
	
	private List<CouponDto> couponsDto;
	
	/**
	 * Call the cached list into the service
	 */
	@Override
	public List<Coupon> findAll() {
		List<Coupon> coupons = null;
		try {
			if(this.couponsDto != null && !this.couponsDto.isEmpty()) {
				coupons = ResourceTransformer.transformDtosToCoupon(this.couponsDto);
			}
		} catch (ParseException e) {
			// TODO Logger
		}
		return coupons;
	}
	
	/**
	 * Execute the call each "${coupons.refresh.time}" milliseconds
	 * to refresh the cached list
	 */
	@Scheduled(fixedRateString = "${coupons.refresh.time}")
	public void refreshData() {
		if(this.couponsDto != null ) {
			this.couponsDto.clear();
		}
		this.couponsDto = this.client.findAll();
	}

}
