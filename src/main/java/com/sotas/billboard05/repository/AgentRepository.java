package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.Agent;
import com.sotas.billboard05.entity.Billboard;

public interface AgentRepository extends CrudRepository<Agent, Integer> {
    Agent getByLogin(String  login);
}
