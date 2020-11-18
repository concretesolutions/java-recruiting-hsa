/*
 * 
 */
package com.accenture.concrete.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.concrete.client.IClienteCategorias;
import com.accenture.concrete.client.IClienteCupones;
import com.accenture.concrete.domain.Categories;
import com.accenture.concrete.domain.Coupon;
import com.accenture.concrete.domain.SubCategoriaN2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConcreteServiceImpl implements IConcreteService {

	@Autowired
	private IClienteCategorias iClienteCategorias;

	@Autowired
	private IClienteCupones iClienteCupones;

	/**
	 * Gets the top categorias.
	 *
	 * @return the top categorias
	 */
	@Override
	public List<SubCategoriaN2> getTopCategorias() {
		// Se busca el arbol de categorias
		List<Categories> categorias = iClienteCategorias.getCategorias();
		List<SubCategoriaN2> cat2 = new ArrayList<>();

		// Se extraen solo las subcategorias pedidas.
		for (Categories categories : categorias) {
			cat2 = categories.getSubcategories();
		}
		// Se ordena la lista por relevancia.
		List<SubCategoriaN2> sortedList = cat2.stream().sorted(Comparator.comparingInt(SubCategoriaN2::getRelevance))
				.collect(Collectors.toList());

		List<SubCategoriaN2> myLastPosts = new ArrayList<>();

		// validacion en caso de que la lista venga menos a 5, se devuleve la lista
		// completa.
		if (5 <= sortedList.size()) {
			myLastPosts = sortedList.subList(sortedList.size() - 5, sortedList.size());
		} else {
			myLastPosts.addAll(sortedList);
		}
		log.debug(myLastPosts.toString());
		return myLastPosts;
	}

	/**
	 * Gets the cupones.
	 *
	 * @return the cupones
	 */
	@Override
	public List<Coupon> getCupones() {
		// Se buscan todos los cupones disponibles
		List<Coupon> allCoupon = iClienteCupones.getCupones();
		List<Coupon> returnCoupon = new ArrayList<>();

		// Se parsea la fecha a Localdate (java8) y se hace una comparacion con la fecha
		// actual para validar los expirados
		// Se agregan a la lista los que cumplan la condicion.
		for (Coupon coupon : allCoupon) {
			LocalDate date = LocalDate.parse(coupon.getExpiresAt());
			if (LocalDate.now().isBefore(date)) {
				returnCoupon.add(coupon);
			}
		}
		log.debug(returnCoupon.toString());
		return returnCoupon;
	}

	/**
	 * Gets the others categorys.
	 *
	 * @return the others categorys
	 */
	@Override
	public List<SubCategoriaN2> getOthersCategorys() {
		// Se busca el arbol de categorias
		List<Categories> categorias = iClienteCategorias.getCategorias();
		List<SubCategoriaN2> onlySubcategory = new ArrayList<>();
		// Se extraen solo las subcategorias necesarias
		for (Categories categories : categorias) {
			if (onlySubcategory.isEmpty()) {
				onlySubcategory.addAll(categories.getSubcategories());
			}
		}

		// se realiza una llamada al getTopCategorias para ir a buscar el top de
		// categorias
		List<SubCategoriaN2> rest = getTopCategorias();
		// resto el top de categorias a la lista
		onlySubcategory.removeAll(rest);

		log.debug(onlySubcategory.toString());
		return onlySubcategory;
	}

}