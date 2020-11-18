package com.accenture.concrete.service.impl;

import java.util.List;

import com.accenture.concrete.domain.Coupon;
import com.accenture.concrete.domain.SubCategoriaN2;

/**
 * The Interface IConcreteService.
 */
public interface IConcreteService {

	/**
	 * Gets the top categorias.
	 *
	 * @return the top categorias
	 */
	List<SubCategoriaN2> getTopCategorias();

	/**
	 * Gets the others categorys.
	 *
	 * @return the others categorys
	 */
	List<SubCategoriaN2> getOthersCategorys();

	/**
	 * Gets the cupones.
	 *
	 * @return the cupones
	 */
	List<Coupon> getCupones();

}
