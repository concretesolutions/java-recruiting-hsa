package com.accenture.test.matias.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

/**
 * Utils for dates.
 * 
 * @author Matias Gomez Arancibia
 *
 */
@Slf4j
public class DateUtils {

    /**
     * Method that parse a date with a specific format.
     * 
     * @param date Date to parse.
     * @param format Format given (eg. 'yyyy-MM-dd').
     * @return The date parsed. Returns null if any input is invalid.
     */
    public static Date getDateWithFormat(String date, String format) {

        if (AccentureUtils.isNullOrEmpty(date) || AccentureUtils.isNullOrEmpty(format)) {
            return null;
        }

        Date response = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        try {
            response = sdf.parse(date);
        } catch (ParseException e) {
            log.error("Error al parsear la fecha {} con el formato {}. Error: {}", date, format, e);
        }
        return response;
    }

    /**
     * Method that truncate a date at day.
     * 
     * @param date Date to truncate
     * @return date truncated at day.
     */
    public static Date truncateDateAtDay(Date date) {

        return org.apache.commons.lang3.time.DateUtils.truncate(date, Calendar.DAY_OF_MONTH);
    }

    /**
     * Method that compare two dates.
     * 
     * @param date1 First date to compare.
     * @param date2 Second date to compare.
     * @return true if the first date is equals or before the second date.
     *         Returns false any other case.
     */
    public static boolean isFirstDateAfterSecond(Date date1, Date date2) {

        return date1.compareTo(date2) < 0;
    }

}
