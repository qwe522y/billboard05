package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.City;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBeanByType;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CityRepositoryJpaImpTest extends AbstractRepositoryTest {
    @SpringBeanByType
    private CityRepositoryJpaImpl repository;

    @Test
    @DataSet
    public void get() {
        City e = repository.get(99);
        System.out.println(e);
        assertEquals("London", e.getName());
    }

    @Test
    @DataSet
    public void getAll() {
        List<City> list = repository.getAll();
        assertEquals(3, list.size());
        assertEquals(97, list.get(0).getId());
        assertEquals(98, list.get(1).getId());
        assertEquals(99, list.get(2).getId());
    }
}
