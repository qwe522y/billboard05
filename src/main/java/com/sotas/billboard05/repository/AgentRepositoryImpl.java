package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.Agent;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class AgentRepositoryImpl extends CrudRepositoryImpl<Agent, Integer> implements AgentRepository {
    public AgentRepositoryImpl() {
        super(Agent.class);
    }

    @Override
    public Agent getByLogin(String login) {
        try {
            return getEntityManager().createQuery("SELECT e FROM Agent e WHERE e.login=:login", Agent.class)
                    .setParameter("login", login).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
