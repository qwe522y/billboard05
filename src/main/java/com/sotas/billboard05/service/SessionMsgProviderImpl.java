package com.sotas.billboard05.service;

import com.sotas.billboard05.SessionMsg;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Component
public class SessionMsgProviderImpl implements SessionMsgProvider {
    @Override
    public void push(String msg, SessionMsg.Status status) {
        getSession().setAttribute("msg", new SessionMsg(msg, status));
    }

    @Override
    public SessionMsg pop() {
        HttpSession session = getSession();
        SessionMsg msg = (SessionMsg) session.getAttribute("msg");
        session.removeAttribute("msg");
        return msg;
    }

    private static HttpSession getSession() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession();
    }

}
