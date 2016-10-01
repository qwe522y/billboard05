package com.sotas.billboard05.service;

import com.sotas.billboard05.entity.BillboardType;
import com.sotas.billboard05.repository.BillboardTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillboardTypeServiceImpl implements BillboardTypeService {
    private BillboardTypeRepository repository;
    @Autowired
    public BillboardTypeServiceImpl(BillboardTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BillboardType> getAll() {
        return repository.getAll();
    }
}
