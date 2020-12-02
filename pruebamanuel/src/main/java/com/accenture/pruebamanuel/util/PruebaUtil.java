package com.accenture.pruebamanuel.util;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * Clase que contiene el utilitario del proyecto.
 * 
 * @author Manuel Jimenez
 */
@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PruebaUtil {

	private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Obtiene la fecha actual en el formato yyyyMMdd.
	 * 
	 * @return Fecha actual en el formato yyyyMMdd
	 */
	public static Date getDate() {

		Date fecha = new Date();
		DATE_FORMAT.format(fecha);
		return fecha;
	}

	/**
	 * realiza transformacion de string a Date en formato yyyyMMdd.
	 * 
	 * @return Fecha actual en el formato yyyyMMdd
	 * @throws ParseException
	 */
	public static Date stringToDate(String fecha) throws ParseException {

		Date fechaDate = null;
		fechaDate = DATE_FORMAT.parse(fecha);
		return fechaDate;
	}

	/**
	 * valida que el string no sea nulo o vacio.
	 * 
	 * @param string a validate.
	 * @return true or false.
	 */
	public static boolean notNullOrEmpty(String string) {

		return string != null && !string.trim().isEmpty();
	}

	/**
	 * Metodo que compara 2 fechas.
	 * 
	 * @param fechaExpiracion fecha de expiracion.
	 * @param fecha           fecha actual.
	 * @return retorna un int segun la comparacion 0 si son iguales, valor + si es
	 *         mayor y - si es menor.
	 */
	public static int compareDate(Date fechaExpiracion, Date fecha) {

		return fechaExpiracion.compareTo(fecha);
	}

	/**
	 * Metodo que le un Objeto Json y mapea a una clase.
	 * 
	 * @param <S>      class type.
	 * @param filename filename
	 * @param template template.
	 * @return json.
	 */
	public static <S> S readJson(String filename, Class<S> template) {

		try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)) {

			String result = IOUtils.toString(Objects.requireNonNull(inputStream), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(result, template);
		} catch (Exception ex) {
			log.error("Error getting object from json file", ex);
			return null;
		}
	}
}
