package com.concrete.challenge.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DateUtil {

    public LocalDate getToday() {
        return LocalDate.now();
    }
}
