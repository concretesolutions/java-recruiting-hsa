package cl.concrete.desafio.ecommerce.webservice.client.rest;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.concrete.desafio.ecommerce.webservice.client.model.CouponDto;

@FeignClient(name = "coupons", url = "https://cs-hsa-api-coupons.herokuapp.com")
public interface CouponsRestClient {

	@RequestMapping(method = RequestMethod.GET, value = "/coupons")
	public List<CouponDto> findAll();

}
