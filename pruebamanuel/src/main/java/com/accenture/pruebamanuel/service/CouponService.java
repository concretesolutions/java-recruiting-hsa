package com.accenture.pruebamanuel.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.pruebamanuel.client.CouponsClient;
import com.accenture.pruebamanuel.model.Cupon;
import com.accenture.pruebamanuel.util.PruebaUtil;

import lombok.extern.log4j.Log4j2;

/**
 * Service que permite contiene logica referente a cupones.
 * 
 * @author Manuel Jimenez
 */
@Log4j2
@Service
public class CouponService {

	/**
	 * cliente que llama a la api de cupones.
	 */
	@Autowired
	private CouponsClient couponClient;

	/**
	 * Metodo que contiene la logica para la obtencion del listado de cupones
	 */
	public List<Cupon> getCoupon() {

		log.debug("[getCoupon] Inicio");

		List<Cupon> cupones = new ArrayList<>();
		try {
			cupones = couponClient.getCoupons().getBody();
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (cupones.isEmpty() || cupones == null) {
			log.error("[getCoupon] Error, listado de cupones es null o vacio");
			// TODO: falta agrega logica de excepciones
		}

		log.debug("[getCoupon] Fin.");
		return filterCoupon(cupones);
	}

	/**
	 * Metodo que realiza filtro de los cupones expirados.
	 * 
	 * @param cupones
	 */
	private List<Cupon> filterCoupon(List<Cupon> cupones) {

		log.debug("[filterCoupon] Inicio");

		Date fecha = PruebaUtil.getDate();
		cupones.removeIf(c -> removeExpired(c.getExpiresAt(), fecha));

		log.debug("[filterCoupon] Fin");
		return cupones;
	}

	/**
	 * Metodo que valida si el registro debe ser eliminado
	 * 
	 * @param expiresAt fecha de expiracion.
	 * @param fecha     fecha actual.
	 * @return Boolean.
	 */
	private boolean removeExpired(String expiresAt, Date fecha) {

		log.debug("[removeExpired] Inicio fechaExpiracion[{}], fechaActual[{}]", expiresAt, fecha);

		if (!PruebaUtil.notNullOrEmpty(expiresAt)) {
			log.warn("[removeExpired] Warning campo expiresAt es null o vacio.");
			return true;
		}

		Date fechaExpiracion = null;
		try {
			fechaExpiracion = PruebaUtil.stringToDate(expiresAt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (PruebaUtil.compareDate(fechaExpiracion, fecha) == 0 || PruebaUtil.compareDate(fechaExpiracion, fecha) > 0) {

			log.debug("[removeExpired] Fin");
			return false;
		} else {

			log.debug("[removeExpired] Fin");
			return true;
		}
	}

}
