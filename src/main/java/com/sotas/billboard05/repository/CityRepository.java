package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.City;

import java.util.List;

public interface CityRepository {
    City get(Integer id);
    List<City> getAll();
}
