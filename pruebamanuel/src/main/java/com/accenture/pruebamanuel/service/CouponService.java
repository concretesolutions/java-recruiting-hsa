package com.accenture.pruebamanuel.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.pruebamanuel.client.CouponsClient;
import com.accenture.pruebamanuel.exception.BadRequestException;
import com.accenture.pruebamanuel.exception.ConflictException;
import com.accenture.pruebamanuel.exception.InternalServerErrorException;
import com.accenture.pruebamanuel.exception.ServiceUnavailableException;
import com.accenture.pruebamanuel.model.Cupon;
import com.accenture.pruebamanuel.util.Constant;
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
	 * 
	 * @return List<Cupon>
	 */
	public List<Cupon> getCoupon() {

		log.debug("[getCoupon] Inicio");

		List<Cupon> cupones = new ArrayList<>();
		try {
			cupones = couponClient.getCoupons().getBody();
			validateResponse(cupones);
		} catch (Exception e) {
			log.error("[getCoupon]Error ocurrio un error al ejecutar la api de cupones");
			throw new ServiceUnavailableException(Constant.SERVICEUNAVAILABLE_MESSAGE,
					Constant.SERVICEUNAVAILABLE_SOLUTION, Constant.SERVICEUNAVAILABLE_CODE);
		}

		log.debug("[getCoupon] Fin.");
		return filterCoupon(cupones);
	}

	/**
	 * Metodo que valida la respuesta de la api de cupones.
	 * 
	 * @param List<Cupon>.
	 */
	private void validateResponse(List<Cupon> cupones) {
		if (cupones == null || cupones.isEmpty()) {
			log.error("[getCoupon] Error, listado de cupones es null o vacio");
			throw new ConflictException("Error listado de cupones es null o vacio", Constant.CONFLICT_SOLUTION,
					Constant.CONFLICT_CODE);
		}
	}

	/**
	 * Metodo que realiza filtro de los cupones expirados.
	 * 
	 * @param cupones.
	 */
	private List<Cupon> filterCoupon(List<Cupon> cupones) {

		log.debug("[filterCoupon] Inicio");

		Date fecha = PruebaUtil.getDate();

		if (fecha == null) {
			log.error("[getCoupon]Error ocurrio un error al ejecutar la api de cupones");
			throw new BadRequestException("Fecha no puede ser nula o vacio", Constant.BADREQUEST_SOLUTION,
					Constant.BADREQUEST_CODE);
		}

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
			log.error("[removeExpired]Error ocurrio un error al parcear la fecha");
			throw new InternalServerErrorException(Constant.INTERNALSERVERERROR_MESSAGE,
					Constant.INTERNALSERVERERROR_SOLUTION, Constant.INTERNALSERVERERROR_CODE);
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
