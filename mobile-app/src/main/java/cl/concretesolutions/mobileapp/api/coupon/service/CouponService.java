package cl.concretesolutions.mobileapp.api.coupon.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.concretesolutions.mobileapp.api.coupon.CouponClient;
import cl.concretesolutions.mobileapp.api.coupon.CouponDto;

@Service
public class CouponService {

	@Autowired
	private CouponClient client;
	
	/**
	 * @return list all valid coupons 
	 */
	public List<CouponDto> getCoupons() {
		List<CouponDto> coupons = client.getCoupons();
		LocalDate toDay = LocalDate.now();
		return coupons.stream()
			.filter(x -> x.getExpiresAt().isAfter(toDay))
			.collect(Collectors.toList());
	}
}
