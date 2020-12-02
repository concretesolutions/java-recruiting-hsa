package com.accenture.pruebamanuel.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.accenture.pruebamanuel.model.Cupon;

/**
 * Interface que permite la comunicacion con el servicio legado de cupones.
 * 
 * @author Manuel Jimenez.
 */
@FeignClient(name = "coupon-api", url = "https://cs-hsa-api-coupons.herokuapp.com")
public interface CouponsClient {

	/**
	 * Metodo que obtiene el listado de cupones.
	 * 
	 * @return List<Cupon>.
	 */
	@GetMapping("/coupons")
	public ResponseEntity<List<Cupon>> getCoupons();
}
