package com.sotas.billboard05.utils;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StringUtils;

/**
 * АОП логгер. Можно подключить к функции, логирует входные параметры и возврат.
 */
public class AopRoundLogger {
    private Logger log = Logger.getLogger(AopRoundLogger.class.getName());

    /**
     *  выводит в лог входные параметры
     */
    void before(JoinPoint joinPoint) {
        log.debug("begin " + joinPoint.getTarget().getClass().getSimpleName() + "." + joinPoint.getSignature().getName() + "(" + StringUtils.arrayToDelimitedString(joinPoint.getArgs(), ", ") + ")");
    }

    /**
     * логирует входные параметры и возврат.
     */
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.debug("begin " + pjp.getTarget().getClass().getSimpleName() + "." + pjp.getSignature().getName() + "(" + StringUtils.arrayToDelimitedString(pjp.getArgs(), ", ") + ")");
        try {
            Object res = pjp.proceed();
            log.debug("end " + pjp.getSignature().getName() + "(" + StringUtils.arrayToDelimitedString(pjp.getArgs(), ", ") + ") return " + res);
            return res;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }
}