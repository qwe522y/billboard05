package com.sotas.billboard05.utils;

public class I18nUtils {
    public static String timetableStatus(int status) {
        switch (status) {
            case 1000:
                return "Занято";
            case 0:
            case 100:
                return "Свободено";
        }
        throw new RuntimeException("status="+status);
    }
}
