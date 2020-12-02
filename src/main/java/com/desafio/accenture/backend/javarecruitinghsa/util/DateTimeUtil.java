package com.desafio.accenture.backend.javarecruitinghsa.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.TimeZone;

/**
 * Utilitario que opera con fechas y unidades de tiempos.
 * <br><br>
 * <b>Nota</b>: La clase no puede ser extendida (final) dado que es un utilitario.
 *
 */
public final class DateTimeUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(DateTimeUtil.class);
    private static final String ERROR_PARSING_DATE = "Error parsing date";

    private DateTimeUtil() {
        throw new AssertionError(
            "You can't get a instance for " + DateTimeUtil.class.getName() + ", because is a utilitary.");
    }

    /**
     * Obtiene la fecha actual en UTC (Universal Time Coordinated)
     *
     * @return Fecha actual en UTC.
     */
    public static Date getCurrentDateUTC() {
        LocalDateTime utc = LocalDateTime.now(ZoneId.of(ZoneOffset.UTC.getId()));
        return Date.from(utc.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Obtiene la fecha actual del sistema.
     *
     * @return Fecha actual del sistema.
     */
    public static Date getCurrentDateSystemTime() {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.systemDefault());
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date stringToDate(String dateStr, String format) {
        if (dateStr == null || format == null) {
            String message = String.format("An illegal argument value found. No argument can be null. dateStr: %s, format: %s", dateStr, format);
            throw new IllegalArgumentException(message);
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            LOGGER.error(ERROR_PARSING_DATE, e);
        }
        return null;
    }

}
