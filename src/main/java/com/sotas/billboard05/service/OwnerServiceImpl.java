package com.sotas.billboard05.service;

import com.sotas.billboard05.entity.Owner;
import com.sotas.billboard05.repository.OwnerRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OwnerServiceImpl implements OwnerService {
    private OwnerRepository repository;
    @Override
    public Map<Integer, Owner> getAsMap() {
        List<Owner> owners = repository.getAll();
        Map<Integer, Owner> res = new HashMap<>();
        for(Owner e : owners) res.put(e.getId(), e);
        return res;
    }
}
