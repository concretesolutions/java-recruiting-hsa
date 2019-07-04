package cl.accenture.concrete.challenge.rest.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.accenture.concrete.challenge.data.interfaces.CouponInterface;
import cl.accenture.concrete.challenge.model.Coupon;
import cl.accenture.concrete.challenge.rest.CouponRest;

@RestController
public class CouponRestImpl implements CouponRest {
	private static final Log log = LogFactory.getLog(CouponRestImpl.class);

	@Autowired
	private CouponInterface couponClient;
	
	@Autowired
    private CacheManager cacheManager;

	@GetMapping("${coupons.api.url.path}")
	@Cacheable("${coupons.api.cache.name}")
	public List<Coupon> getCoupons() {
		log.info("Obtaining Coupons");
		return couponClient.getCoupons();
	}
	
	@Scheduled(fixedRateString = "${coupons.api.cache.time}")
	private void retrieveData() {
		log.info("Clearing Coupons Cache");
		cacheManager.getCache("${coupons.api.cache.name}").clear();
	}

}
