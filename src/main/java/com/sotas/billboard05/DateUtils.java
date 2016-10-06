package com.sotas.billboard05;

import java.util.Date;

public class DateUtils {
    public static Date curDate;
    public static Date getCurDate() {
        if(curDate == null) return new Date();
        return curDate;
    }
}
