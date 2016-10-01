package com.sotas.billboard05.service;

import com.sotas.billboard05.entity.Owner;
import com.sotas.billboard05.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    private OwnerRepository repository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Owner> getAll() {
        return repository.getAll();
    }
}
