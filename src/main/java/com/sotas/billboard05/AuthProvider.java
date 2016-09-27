package com.sotas.billboard05;

import com.sotas.billboard05.entity.Agent;
import com.sotas.billboard05.service.AgentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthProvider implements UserDetailsService {
    private static Logger log = Logger.getLogger(AuthProvider.class.getName());
    private AgentService agentService;

    @Autowired
    public AuthProvider(AgentService agentService) {
        this.agentService = agentService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        log.info("begin loadUserByUsername login=" + login);
        Agent agent = agentService.getByLogin(login);
        if(agent == null) throw new UsernameNotFoundException("can not found user by login " + login);
        log.info("return " + agent);
        return new AuthUser(agent);
    }
}