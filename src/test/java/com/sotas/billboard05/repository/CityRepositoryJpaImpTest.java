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
    @ExpectedDataSet
    public void addWithGenerationId() {
        final City e = new City("newtname", "newtphone");
        City e2 = txTemplate.execute(transactionStatus -> repository.add(e));
        assertNotEquals(0, e2.getId());
    }

    @Test
    @DataSet
    public void get() {
        City e = repository.get(99);
        System.out.println(e);
        assertEquals("tname", e.getName());
    }

    @Test
    @DataSet
    @ExpectedDataSet
    public void update() {
        City e = repository.get(99);
        e.setLocation("newtphone");
        txTemplate.execute(transactionStatus -> repository.update(e));
    }

    @Test
    @DataSet
    public void remove() {
        txTemplate.execute(transactionStatus -> repository.remove(99));
        assertNull(repository.get(99));
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
