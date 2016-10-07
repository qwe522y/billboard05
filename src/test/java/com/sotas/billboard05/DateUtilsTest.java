package com.sotas.billboard05;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class DateUtilsTest {
    @Test
    public void getEndOfMonth() {
        Calendar cal = DateUtils.getEndOfMonth(2016, 2);
        assertEquals(2016, cal.get(Calendar.YEAR));
        assertEquals(1, cal.get(Calendar.MONTH));
        assertEquals(29, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(Calendar.MONDAY, cal.get(Calendar.DAY_OF_WEEK));
    }

    @Test
    public void getBeginOfMonth() {
        Calendar cal = DateUtils.getBeginOfMonth(2016, 11, 2);
        assertEquals(2017, cal.get(Calendar.YEAR));
        assertEquals(1, cal.get(Calendar.MONTH));
        assertEquals(1, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(Calendar.MONDAY, cal.get(Calendar.DAY_OF_WEEK));
    }
}
