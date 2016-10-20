package com.sotas.billboard05.service;

import com.sotas.billboard05.entity.Owner;
import com.sotas.billboard05.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    private OwnerRepository repository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Owner> getByAgent(int id) {
        return repository.getByAgent(id);
    }

    @Override
    public Owner get(int id) {
        return repository.get(id);
    }

    @Transactional
    @Override
    public Owner add(Owner owner) {
        return repository.add(owner);
    }

    @Override
    @Transactional
    public void update(Owner owner) {
        repository.update(owner);
    }
}
