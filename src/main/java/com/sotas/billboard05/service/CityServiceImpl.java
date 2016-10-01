package com.sotas.billboard05.service;

import com.sotas.billboard05.entity.City;
import com.sotas.billboard05.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private CityRepository repository;

    @Autowired
    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<City> getAll() {
        return repository.getAll();
    }
}
