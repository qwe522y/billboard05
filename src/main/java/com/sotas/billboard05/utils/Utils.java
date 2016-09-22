package com.sotas.billboard05.utils;

import org.apache.log4j.Logger;

public class Utils {
    private static Logger log = Logger.getLogger(Utils.class);
    public static void close(AutoCloseable... items) {
        for(AutoCloseable i : items) {
            try {
                if(i!= null) i.close();
            } catch (Exception e) {
                log.error(i + e.getMessage(), e);
            }
        }
    }
}
