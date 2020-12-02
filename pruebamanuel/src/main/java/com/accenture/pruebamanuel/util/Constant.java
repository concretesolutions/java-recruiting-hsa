package com.accenture.pruebamanuel.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Clase que contiene las Constantes del proyecto.
 * 
 * @author Manuel Jimenez
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constant {

	/**
	 * BADREQUEST_MESSAGE.
	 */
	public static final String BADREQUEST_MESSAGE = "La petici\u00F3n recibida no es valida";

	/**
	 * BADREQUEST_CODE.
	 */
	public static final String BADREQUEST_CODE = "400";

	/**
	 * BADREQUEST_SOLUTION.
	 */
	public static final String BADREQUEST_SOLUTION = "Prueba revisando la validez de la informaci\u00F3n proporcionada";

	/**
	 * SERVICEUNAVAILABLE_CODE
	 */
	public static final String SERVICEUNAVAILABLE_CODE = "503";

	/**
	 * SERVICEUNAVAILABLE_MESSAGE.
	 */
	public static final String SERVICEUNAVAILABLE_MESSAGE = "Un servicio necesario est\u00E1 sufriendo problemas";

	/**
	 * SERVICEUNAVAILABLE_SOLUTION.
	 */
	public static final String SERVICEUNAVAILABLE_SOLUTION = "Prueba contactando a un administrador para que revisen y habiliten dicho servicio lo m\u00E1s pronto posible";

	/**
	 * CONFLICT_CODE
	 */
	public static final String CONFLICT_CODE = "409";

	/**
	 * CONFLICT_MESSAGE.
	 */
	public static final String CONFLICT_MESSAGE = "Conflicto al procesar la petici\u00F3n";

	/**
	 * CONFLICT_SOLUTION.
	 */
	public static final String CONFLICT_SOLUTION = "Pruebe intentando nuevamente, en caso de continuar con el problema pruebe contactando a un administrador para que revisen y solucionen el conflicto lo m\u00E1s pronto posible";

	/**
	 * INTERNALSERVERERROR_CODE.
	 */
	public static final String INTERNALSERVERERROR_CODE = "500";

	/**
	 * INTERNALSERVERERROR_MESSAGE.
	 */
	public static final String INTERNALSERVERERROR_MESSAGE = "Ha ocurrido un error inesperado";

	/**
	 * INTERNALSERVERERROR_SOLUTION.
	 */
	public static final String INTERNALSERVERERROR_SOLUTION = "Prueba contactando a un administrador para que revisen y solucionen dicho error lo m\u00E1s pronto posible";
}
