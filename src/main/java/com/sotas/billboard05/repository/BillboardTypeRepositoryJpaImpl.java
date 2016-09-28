package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.BillboardType;
import org.springframework.stereotype.Repository;

@Repository
public class BillboardTypeRepositoryJpaImpl extends CrudRepositoryJpaImpl<BillboardType, Integer> implements BillboardTypeRepository {
    public BillboardTypeRepositoryJpaImpl() {
        super(BillboardType.class);
    }
}
