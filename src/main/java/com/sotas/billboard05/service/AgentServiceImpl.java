package com.sotas.billboard05.service;

import com.sotas.billboard05.entity.Agent;
import com.sotas.billboard05.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentServiceImpl implements AgentService {
    AgentRepository repository;

    @Autowired
    public AgentServiceImpl(AgentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Agent getByLogin(String login) {
        return repository.getByLogin(login);
    }
}
