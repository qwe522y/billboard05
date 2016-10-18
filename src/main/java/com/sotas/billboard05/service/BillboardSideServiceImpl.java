package com.sotas.billboard05.service;

import com.sotas.billboard05.entity.BillboardSide;
import com.sotas.billboard05.repository.BillboardSideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BillboardSideServiceImpl implements BillboardSideService {
    @Autowired
    private BillboardSideRepository repository;

    @Override
    public BillboardSide get(int id) {
        return repository.get(id);
    }

    @Override
    public List<BillboardSide> getByBillboard(int billboardId) {
        return repository.getByBillboard(billboardId);
    }

    @Transactional
    @Override
    public void add(BillboardSide e) {
        repository.add(e);
    }

    @Transactional
    @Override
    public void update(BillboardSide e) {
        repository.update(e);
    }
}
