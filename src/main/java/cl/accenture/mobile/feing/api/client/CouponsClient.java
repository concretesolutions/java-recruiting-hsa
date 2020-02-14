package cl.accenture.mobile.feing.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cl.accenture.mobile.domain.Coupons;
import cl.accenture.mobile.feing.api.configuration.CouponsConfiguration;
import feign.Headers;

/**
 * Cliente Feign que realiza las llamadas a la api de cupones
 * @author andrea.rojas.ruiz
 *
 */
@FeignClient(url = "${api.coupons.url}", name = "${api.coupons.name}", configuration = CouponsConfiguration.class)
public interface CouponsClient {

	@GetMapping("/coupons")
	@Headers("accept: application/json")
	public List<Coupons> getCoupons();
}
