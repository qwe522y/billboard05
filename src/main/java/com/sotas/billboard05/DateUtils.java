package com.sotas.billboard05;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    public static Date curDate;
    public static Date getCurDate() {
        if(curDate == null) return new Date();
        return curDate;
    }

    public static Calendar getEndOfMonth(int year, int month, int addMonth) {
        Calendar cal = new GregorianCalendar(year, month, 1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getMaximum(Calendar.DAY_OF_MONTH));
        return cal;
    }

    public static Calendar getBeginOfMonth(int year, int month) {
        return new GregorianCalendar(year, month, 1);
    }
}
