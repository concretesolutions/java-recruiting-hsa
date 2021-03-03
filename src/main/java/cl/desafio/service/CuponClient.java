package cl.desafio.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.desafio.model.Cupon;

@FeignClient(name="cupones",url = "https://cs-hsa-api-coupons.herokuapp.com")
public interface CuponClient {

	  @RequestMapping(method = RequestMethod.GET, value = "/coupons")
	    List<Cupon> getCupones();
}
