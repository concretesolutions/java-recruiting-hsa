package cl.recruiting.hsa.proyecto.legacy.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cl.recruiting.hsa.proyecto.legacy.model.Coupon;

@FeignClient(name = "couponFeignClient", url = "${legacy.coupon.url}")
public interface CouponFeignClient {

	@GetMapping("/coupons.json")
    List<Coupon> getAllCoupons();
	
}
