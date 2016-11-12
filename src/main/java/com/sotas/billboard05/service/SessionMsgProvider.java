package com.sotas.billboard05.service;

import com.sotas.billboard05.SessionMsg;

public interface SessionMsgProvider {
    void push(String msg, SessionMsg.Status status);
    SessionMsg pop();
}
