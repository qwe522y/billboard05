package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.Billboard;
import org.springframework.stereotype.Repository;

@Repository
public class BillboardRepositoryImpl extends CrudRepositoryImpl<Billboard, Integer> implements BillboardRepository {

    public BillboardRepositoryImpl() {
        super(Billboard.class);
    }
}
