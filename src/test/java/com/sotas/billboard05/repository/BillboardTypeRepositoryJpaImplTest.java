package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.BillboardType;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBeanByType;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class BillboardTypeRepositoryJpaImplTest extends AbstractRepositoryTest {
    @SpringBeanByType
    private BillboardTypeRepositoryJpaImpl repository;

    @Test
    @DataSet
    public void get() {
        BillboardType e = repository.get(99);
        System.out.println(e);
        assertEquals("Щит", e.getName());
    }

    @Test
    @DataSet
    public void getAll() {
        List<BillboardType> list = repository.getAll();
        assertEquals(3, list.size());
        assertEquals("Обычный баннер", list.get(0).getName());
        assertEquals("Растяжка", list.get(1).getName());
        assertEquals("Щит", list.get(2).getName());
    }
}
