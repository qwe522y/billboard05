package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.Owner;
import org.springframework.stereotype.Repository;

@Repository
public class OwnerRepositoryJpaImpl extends CrudRepositoryJpaImpl<Owner, Integer> implements OwnerRepository {
    public OwnerRepositoryJpaImpl() {
        super(Owner.class);
    }
}
