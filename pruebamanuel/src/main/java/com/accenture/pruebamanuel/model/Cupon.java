package com.accenture.pruebamanuel.model;

import lombok.Data;

/**
 * Modelo que representa un objeto Cupon.
 * 
 * @author Manuel Jimenez
 */

@Data
public class Cupon {

	/**
	 * Id del cupon.
	 */
	private String id;

	/**
	 * descripcion del cupon.
	 */
	private String description;

	/**
	 * nombre del cupon.
	 */
	private String seller;

	/**
	 * Url de la imagen del cupon.
	 */
	private String image;

	/**
	 * Fecha de Expiracion..
	 */
	private String expiresAt;

}
