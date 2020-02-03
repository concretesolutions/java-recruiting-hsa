package cl.accenture.concrete.feing.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cl.accenture.concrete.domain.DataCoupon;
import cl.accenture.concrete.feing.api.configuration.CouponsConfiguration;
import feign.Headers;

/**
 * Cliente Feign que realiza las llamadas a la api de cupones
 * @author c.leon.palacios
 *
 */
@FeignClient(url = "${api.coupons.url}", name = "${api.coupons.name}", configuration = CouponsConfiguration.class)
public interface CouponsClient {

	@GetMapping("/coupons")
	@Headers("accept: application/json")
	public List<DataCoupon> getAllCoupons();
}
