package com.spring.henallux.templatesSpringProject.util;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateProviderConverter {
    public static Date gregorianCalendarToSqlDate(GregorianCalendar calendar) {
        return new Date(calendar.getTimeInMillis());
    }

    public static GregorianCalendar dateToGregorianCalendar(Date date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar;
    }
}
