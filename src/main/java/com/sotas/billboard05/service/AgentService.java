package com.sotas.billboard05.service;

import com.sotas.billboard05.entity.Agent;

public interface AgentService {
    Agent getByLogin(String login);
}
