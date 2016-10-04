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
    @ExpectedDataSet
    public void addWithGenerationId() {
        final BillboardType e = new BillboardType("Обычный щит", 2);
        BillboardType e2 = txTemplate.execute(transactionStatus -> repository.add(e));
        assertNotEquals(0, e2.getId());
    }

    @Test
    @DataSet
    public void get() {
        BillboardType e = repository.get(99);
        System.out.println(e);
        assertEquals("Щит", e.getName());
    }

    @Test
    @DataSet
    @ExpectedDataSet
    public void update() {
        BillboardType e = repository.get(99);
        e.setName("Новое название");
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
        List<BillboardType> list = repository.getAll();
        assertEquals(3, list.size());
        assertEquals("Обычный баннер", list.get(0).getName());
        assertEquals("Растяжка", list.get(1).getName());
        assertEquals("Щит", list.get(2).getName());
    }
}
