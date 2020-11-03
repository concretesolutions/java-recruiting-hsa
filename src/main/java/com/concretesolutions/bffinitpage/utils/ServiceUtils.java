/**
 * Backend Code Challenge - forked from concretesolutions/java-recruiting-hsa
 * 
 * Author: Jorge Leiva
 * Mail: jorgeleiva.17@gmail.com
 */
package com.concretesolutions.bffinitpage.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class ServiceUtils {

  ServiceUtils() {
  }

  public static boolean isNonEmpty(String arg) {
    return (arg != null && !arg.isEmpty());
  }

  private static LocalDateTime assignDate(String arg, String pattern) {
    LocalDateTime dateTime = null;
    if (isNonEmpty(arg)) {
      if (arg.length() == 10) {
        arg = arg + " 00";
      }
      try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        dateTime = LocalDateTime.parse(arg, formatter);
      } catch (DateTimeParseException e) {
        return null;
      }
    }
    return dateTime;
  }

  public static LocalDateTime convertDate(String arg, List<String> patterns) {
    LocalDateTime date = null;
    for (String pattern : patterns) {
      date = assignDate(arg, pattern);
      if (date != null) {
        return date;
      }
    }
    return LocalDateTime.now().withYear(0);
  }

}
