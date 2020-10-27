package com.accenture.challenge.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

/**
 * Clase para las utilidades de la aplicación
 * @author Manuel Gutierrez
 *
 */

@Slf4j
public class Utils {
	
	public static Date getDateFromString(String stringDateFormat) {
		
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			if (stringDateFormat != null && !stringDateFormat.isBlank() && !stringDateFormat.isEmpty()) {
				try {
					date = sdf.parse(stringDateFormat);
				} catch (ParseException e) {
					log.error("Error : " + e.getMessage());
					date = null;
				}
			} 
			
			return date;
	}

	/**
	 * Compara dos fechas.
	 * @param expireDate
	 * @return
	 */
	public static Boolean isExpireDate(Date expireDate) {
		
		Date now = new Date(); 
		return expireDate.compareTo(now) < 0 ? Boolean.TRUE : Boolean.FALSE;  	
		
	}
	

}
