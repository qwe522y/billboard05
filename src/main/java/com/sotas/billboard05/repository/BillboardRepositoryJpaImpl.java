package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.Billboard;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillboardRepositoryJpaImpl extends CrudRepositoryJpaImpl<Billboard, Integer> implements BillboardRepository {

    public BillboardRepositoryJpaImpl() {
        super(Billboard.class);
    }

    @Override
    public List<Billboard> getListByCity(int cityId) {
        return getEntityManager().createQuery("SELECT e FROM Billboard e WHERE e.cityId=:city", Billboard.class).setParameter("city", cityId).getResultList();
    }

    @Override
    public List<Billboard> getListByAgent(int agentId) {
        return getEntityManager().createQuery("SELECT e FROM Billboard e WHERE e.agentId=:agent", Billboard.class).setParameter("agent", agentId).getResultList();
    }
}
