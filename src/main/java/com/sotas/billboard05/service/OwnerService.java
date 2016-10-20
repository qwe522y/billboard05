package com.sotas.billboard05.service;

import com.sotas.billboard05.entity.Owner;

import java.util.List;

public interface OwnerService {
    List<Owner> getByAgent(int id);
    Owner get(int id);
    Owner add(Owner owner);
    void update(Owner owner);
}
