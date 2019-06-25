package cl.concrete.desafio.ecommerce.webservice.client.service;

import java.util.List;

import cl.concrete.desafio.ecommerce.webservice.client.model.Coupon;

public interface CouponsService {

	public List<Coupon> findAll();
}
