package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.Billboard;

import java.util.List;

public interface BillboardRepository extends CrudRepository<Billboard, Integer> {
    List<Billboard> getListByCity(int cityId);
    List<Billboard> getListByAgent(int agentId);
}
