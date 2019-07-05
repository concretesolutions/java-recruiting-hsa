package cl.accenture.concrete.challenge.rest;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Suppliers;
import com.google.common.base.Supplier;

import cl.accenture.concrete.challenge.data.interfaces.CouponInterface;
import cl.accenture.concrete.challenge.model.Coupon;

@RestController
public class CouponRest {
	// Logger
	private static final Log log = LogFactory.getLog(CouponRest.class);

	// External API Interface
	@Autowired
	private CouponInterface couponClient;
	
	@Value("${coupons.api.dt.format:yyyy-MM-dd}")
	private String dtFormat;

	// API Implementations
	@GetMapping("${coupons.api.url.path}")
	public List<Coupon> getCoupons() {
		log.info("Obtaining Coupons.");
		
		return this.retrieveData();
	}
	
	@GetMapping("${coupons.api.url.path}/valid")
	public List<Coupon> getValidCoupons(){
		log.info("Obtaining Valid Coupons.");
		
		final LocalDate today = LocalDate.now();
		
		return this.retrieveData()
				.stream()
				.filter(x -> x.isValid(today, dtFormat))
				.collect(Collectors.toList());
	}
	
	// Caching
	// The Caching is implemented through Memoization.
	@Value("${coupons.api.cache.time:0}")
	private String cacheTimeout;
	private Supplier<List<Coupon>> cachedCoupons;

	private List<Coupon> retrieveData() {
		log.info("Reading Coupon Data.");

		//Cache initialization.
		if (cachedCoupons == null) {
			cachedCoupons = Suppliers.memoizeWithExpiration(couponClient::getCoupons, Long.valueOf(cacheTimeout),
					TimeUnit.MILLISECONDS);
		}

		//Return the cached object. Or, go and retrieve again the data, 
		//if the cached one already expired.
		return cachedCoupons.get();
	}

}
