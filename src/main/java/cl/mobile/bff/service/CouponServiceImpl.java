package cl.mobile.bff.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.mobile.bff.client.interfaces.CouponClient;
import cl.mobile.bff.domain.CouponClientResponse;
import cl.mobile.bff.exception.ApiInternalServerException;
import cl.mobile.bff.service.interfaces.CouponService;

@Service
public class CouponServiceImpl implements CouponService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CouponServiceImpl.class);
	
	@Autowired
	private CouponClient couponClient; 
	

	@Override
	public List<CouponClientResponse> getCouponNotExpiderd() {
		List<CouponClientResponse> coupons = new ArrayList<>();
		try {
			coupons = couponClient.getCoupons();
			
			if (!coupons.isEmpty()) {
				removeExpiredCoupon(coupons);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new ApiInternalServerException(e);
		}
		
		return coupons;
	}
	
	private List<CouponClientResponse> removeExpiredCoupon(List<CouponClientResponse> coupons) {
		try {
			String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			coupons.removeIf(coupon -> (coupon.getExpiresAt().compareTo(currentDate) == -1));	
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new ApiInternalServerException(e);
		}
		
		return coupons;
	}

}
