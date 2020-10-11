package com.desafio.java.concrete.backend.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    public static Date getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        return ahora;
    }
}
