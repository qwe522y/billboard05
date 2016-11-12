package com.sotas.billboard05;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

public class SessionMsg {
    public static enum Status {
        NOTIFY, SUCCESS, FAIL, WARNING
    }
    private String msg;
    private Status status;

    public SessionMsg(String msg, Status status) {
        this.msg = msg;
        this.status = status;
    }

    @Override
    public String toString() {
        return msg;
    }

    @Deprecated
    public static void pushSessionMsg(String msg, Status status) {
        getSession().setAttribute("msg", new SessionMsg(msg, status));
    }

    private static HttpSession getSession() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
