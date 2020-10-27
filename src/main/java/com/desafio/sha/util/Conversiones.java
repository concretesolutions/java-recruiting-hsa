package com.desafio.sha.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Conversiones {

	private static final Logger LOG = LoggerFactory.getLogger(Conversiones.class);

	private Conversiones() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Metodo que convierte un objeto a String con notación Json
	 * 
	 * @param object Objeto que se desea serializar
	 * @return Cadena Json
	 */
	public static String serializarObjeto(Object objeto) {
		ObjectMapper mapper = new ObjectMapper();

		String json = "";
		try {
			json = mapper.writeValueAsString(objeto);
			return json;
		} catch (JsonProcessingException e) {
			LOG.error("Error al serializar: {} ", e.getMessage());
			return "";
		}
	}

	/* funcion de formato de fecha */
	public static Date stringToDateFormat(String strDate, String format) {

		SimpleDateFormat sdf = new SimpleDateFormat(format);

		Date date;
		try {
			date = sdf.parse(strDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			return cal.getTime();
		} catch (ParseException e) {
			return null;
		}
	}

}
