package com.dynagility.leavingtoolportal.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

public class DateTimeUtil {
    public static final String DATE_TIME_PATTERN = "dd-MM-yyyy HH:mm:ss";

    public static Date toUtilDate(DateTime dateTime) throws ParseException {
        DateFormat formatter = new SimpleDateFormat(DATE_TIME_PATTERN);
        return formatter.parse(dateTime.toString(DATE_TIME_PATTERN));
    }

    public static Date currentDateTimeUTC() throws ParseException {
        return toUtilDate(DateTime.now(DateTimeZone.UTC));
    }

    public static Date nextDateTimeUTC() throws ParseException {
        return toUtilDate(DateTime.now(DateTimeZone.UTC).plusDays(1));
    }

    public static Date currentDateTimeUtcPlus(Long time) throws ParseException {
        return toUtilDate(DateTime.now(DateTimeZone.UTC).plus(time));
    }

    public static Date currentDateTimeUtcMinus(Long time) throws ParseException {
        return toUtilDate(DateTime.now(DateTimeZone.UTC).minus(time));
    }

    public static Date currentDateUTC() throws ParseException {
        DateTime now = DateTime.now(DateTimeZone.UTC);
        DateTime date = new DateTime(now.getYear(), now.getMonthOfYear(), now.getDayOfMonth(), 0, 0, 0, 0,
                DateTimeZone.UTC);

        return toUtilDate(date);
    }

    public static DateTime toDateTimeUTC(long milis)
    {
        return new DateTime(milis, DateTimeZone.UTC);
    }

    public static Date getCurrentDateUTCWithMaxTime() throws ParseException
    {
        return toUtilDate(new DateTime(DateTimeZone.UTC).withMillisOfDay(0).plusDays(1).minusMillis(1));
    }

    public static Date toDateWithZeroTime(Date date) throws ParseException
    {
        DateTime datetime = toDateTimeUTC(date.getTime());

        return toUtilDate(datetime.withMillisOfDay(0));
        
    }

    public static DateTime toDateUTC(String dateString, String pattern)
    {
        return DateTime.parse(dateString, DateTimeFormat.forPattern(pattern).withZoneUTC());
    }

    public static Date toUtilDateUTC(String dateString, String pattern)
    {
        return toDateUTC(dateString, pattern).toDate();
    }
}
