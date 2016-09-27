package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.City;

public class CityRepositoryJpaImpl extends CrudRepositoryJpaImpl<City, Integer> implements CityRepository {
    public CityRepositoryJpaImpl() {
        super(City.class);
    }
}
