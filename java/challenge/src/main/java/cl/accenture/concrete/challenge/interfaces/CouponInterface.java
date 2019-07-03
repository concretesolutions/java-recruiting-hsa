package cl.accenture.concrete.challenge.interfaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.accenture.concrete.challenge.model.Coupon;

@FeignClient(value = "${coupons.api.src.ws.name}", url="${coupons.api.src.ws.endpoint}")
public interface CouponInterface {
	
	@RequestMapping(method = RequestMethod.GET, 
			value = "${coupons.api.src.ws.get.path}", 
			produces = "application/json")
	List<Coupon> getCoupons();
}
