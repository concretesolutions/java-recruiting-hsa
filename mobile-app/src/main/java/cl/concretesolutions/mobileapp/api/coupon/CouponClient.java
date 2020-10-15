package cl.concretesolutions.mobileapp.api.coupon;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="coupon-client", url="${coupons.url.service}")
public interface CouponClient {
	@GetMapping("/coupons")
	List<CouponDto> getCoupons();
}
