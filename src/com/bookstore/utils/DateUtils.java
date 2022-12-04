package com.bookstore.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils extends Throwable{
    public static final String DATE_FORMAT  = "yyyy-MM-dd";
    public static final String DAY_OF_WEEK_FORMAT  = "EEEEE";
    public static Date getDateFromString(String value, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date convertedDate = sdf.parse(value);
        return convertedDate;
    }

    public static String getStringFromDate(Date value, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String date= sdf.format(value);
        return date;
    }

    public static String getDayOfWeekAsString(Date date) {

        DateFormat format2 = new SimpleDateFormat(DAY_OF_WEEK_FORMAT);
        String finalDay = format2.format(date);
        return finalDay.toUpperCase();
    }
}