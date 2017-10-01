package com.popescu.mobiletest.utils;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by atnm-4 on 29/09/2017.
 */
public class Utils {
    public static final DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    public static OkHttpClient okClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.MINUTES)
                .writeTimeout(30, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.MINUTES)
                .build();
    }

    public static int getAge(String date) {
        LocalDate birthdate = dtf.parseLocalDate(date);
        LocalDate now = new LocalDate();
        Years age = Years.yearsBetween(birthdate, now);
        return age.getYears();
    }

    public static String getRegistered(String date) {
        LocalDateTime registered = LocalDateTime.parse(date, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
        return registered.toString("HH:mm");
    }

}
