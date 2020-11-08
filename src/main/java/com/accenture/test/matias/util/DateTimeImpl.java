package com.accenture.test.matias.util;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
class DateTimeImpl implements DateTime {

    @Override
    public Date getDate() {

        return new Date();
    }
}