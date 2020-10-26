package cl.mobile.bff.client.interfaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cl.mobile.bff.domain.CouponClientResponse;
import feign.Headers;

@Headers("accept: application/json")
@FeignClient(value = "coupon", url = "https://cs-hsa-api-coupons.herokuapp.com")
public interface CouponClient {
	
	@Headers("accept: application/json")
	@GetMapping(value = "/coupons")
	public List<CouponClientResponse> getCoupons();

}
