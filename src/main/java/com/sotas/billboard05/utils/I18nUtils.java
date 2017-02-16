package com.sotas.billboard05.utils;

public class I18nUtils {
    public static String timetableStatus(int status) {
        switch (status) {
            case 1000:
                return "Занято";
            case 0:
                return "Свободно";
        }
        throw new RuntimeException("status="+status);
    }

    public static String month(int m) {
        switch (m) {
            case 0: return "январь";
            case 1: return "февраль";
            case 2: return "март";
            case 3: return "апрель";
            case 4: return "май";
            case 5: return "июнь";
            case 6: return "июль";
            case 7: return "август";
            case 8: return "сентябрь";
            case 9: return "октябрь";
            case 10: return "ноябрь";
            case 11: return "декабрь";
        }
        throw new RuntimeException("m=" + m);
    }
}
