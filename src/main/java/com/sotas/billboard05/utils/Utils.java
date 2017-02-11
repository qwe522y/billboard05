package com.sotas.billboard05.utils;

import com.sotas.billboard05.AccessError;
import com.sotas.billboard05.AuthUser;
import com.sotas.billboard05.dto.Month;
import com.sotas.billboard05.entity.Billboard;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    public static List<Month> genMonth(Date date, int len) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        List<Month> res = new ArrayList<>();
        for(int i=0; i<len; i++) {
            res.add(new Month(cal.get(Calendar.MONTH), cal.get(Calendar.YEAR)));
            cal.add(Calendar.MONTH, 1);
        }
        return res;
    }

    public static void checkAccess(Billboard billboard, AuthUser authUser) {
        if(billboard.getAgentId() != authUser.getAgent().getId()) {
            String msg = "billboard.agentId=" + billboard.getAgentId() + " authUser.agent.id=" + authUser.getAgent().getId();
            log.fatal(msg);
            throw new AccessError(msg);
        }
    }
}
