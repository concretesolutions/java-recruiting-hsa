package cl.accenture.concrete.feing.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cl.accenture.concrete.domain.ResponseCoupon;
import cl.accenture.concrete.feing.api.configuration.CouponsConfiguration;
import feign.Headers;


@FeignClient(url = "${api.coupons.url}", name = "${api.coupons.name}", configuration = CouponsConfiguration.class)
public interface CouponsClient {

	@GetMapping("/coupons")
	@Headers("accept: application/json")
	public List<ResponseCoupon> getAllCoupons();
}
