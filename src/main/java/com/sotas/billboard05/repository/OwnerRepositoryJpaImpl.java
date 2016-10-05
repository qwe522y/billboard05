package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.Owner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OwnerRepositoryJpaImpl extends CrudRepositoryJpaImpl<Owner, Integer> implements OwnerRepository {
    public OwnerRepositoryJpaImpl() {
        super(Owner.class);
    }

    @Override
    public List<Owner> getByAgent(int agentId) {
        return getEntityManager().createQuery("SELECT e FROM Owner e WHERE e.agentId=:agentId", Owner.class).setParameter("agentId", agentId).getResultList();
    }
}
