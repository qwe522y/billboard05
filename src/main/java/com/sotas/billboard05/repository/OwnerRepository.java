package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.Owner;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Integer> {
    List<Owner> getByAgent(int agentId);
}
