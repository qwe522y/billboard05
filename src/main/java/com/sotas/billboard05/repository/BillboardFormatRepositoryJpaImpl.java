package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.BillboardFormat;
import org.springframework.stereotype.Repository;

@Repository
public class BillboardFormatRepositoryJpaImpl extends CrudRepositoryJpaImpl<BillboardFormat, Integer> implements BillboardFormatRepository {
    public BillboardFormatRepositoryJpaImpl() {
        super(BillboardFormat.class);
    }
}
