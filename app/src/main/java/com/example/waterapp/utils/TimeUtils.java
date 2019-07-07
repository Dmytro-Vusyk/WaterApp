package com.example.waterapp.utils;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


/**
 * Utility class for work with data and time
 */
public final class TimeUtils {

    private TimeUtils() {

    }

    /**
     *
     */
    public static long getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        return now.toDateTime().getMillis();
    }

    public static String getFormattedTime(long timeInMillis) {
        DateTimeFormatter timeFormatter = DateTimeFormat.forPattern("HH:mm");
        return timeFormatter.print(timeInMillis);
    }

    public static long getStartOfCurrentDay() {
        DateTime startOfDay = new LocalDateTime().toDateTime().withTimeAtStartOfDay();
        return startOfDay.getMillis();
    }

    public static long getEndOfCurrentDay() {
        DateTime startOfDay = new LocalDateTime().toDateTime().millisOfDay().withMaximumValue();
        return startOfDay.getMillis();
    }


}
