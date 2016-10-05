package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.BillboardType;

import java.util.List;

public interface BillboardTypeRepository {
    BillboardType get(Integer id);
    List<BillboardType> getAll();
}
