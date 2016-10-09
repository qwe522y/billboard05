package com.sotas.billboard05;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class DateUtilsTest {
    @Test
    public void getEndOfMonth() {
        Calendar cal = DateUtils.getEndOfMonth(2016, 1, 1);
        assertEquals(2016, cal.get(Calendar.YEAR));
        assertEquals(2, cal.get(Calendar.MONTH));
        assertEquals(31, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(Calendar.THURSDAY, cal.get(Calendar.DAY_OF_WEEK));
    }

    @Test
    public void getBeginOfMonth() {
        Calendar cal = DateUtils.getBeginOfMonth(2016, 11);
        assertEquals(2016, cal.get(Calendar.YEAR));
        assertEquals(11, cal.get(Calendar.MONTH));
        assertEquals(1, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(Calendar.THURSDAY, cal.get(Calendar.DAY_OF_WEEK));
    }
}
