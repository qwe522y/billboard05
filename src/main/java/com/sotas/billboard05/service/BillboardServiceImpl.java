package com.sotas.billboard05.service;

import com.sotas.billboard05.entity.Billboard;
import com.sotas.billboard05.repository.AgentRepository;
import com.sotas.billboard05.repository.BillboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillboardServiceImpl implements BillboardService {
    private BillboardRepository repository;
    private AgentRepository agentRepository;

    @Autowired
    public BillboardServiceImpl(BillboardRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Billboard> getListByCity(int cityId) {
        repository.getListByCity(cityId);
        return null;
    }
}
