package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.Billboard;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBeanByType;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BillboardRepositoryJpaImplTest extends AbstractRepositoryTest {
    @SpringBeanByType
    BillboardRepositoryJpaImpl repository;

    @Test
    @DataSet
    @ExpectedDataSet
    public void addWithGenerationIdAndCreateFields() {
        Billboard e = new Billboard(1, "Новый адрес", 1, 2, true, 3, 4, BigDecimal.ONE, null, 5, 6, null);
        Billboard e2 = txTemplate.execute(transactionStatus -> repository.add(e));
        assertNotEquals(0, e2.getId());
        assertNotNull(e2.getCreateDate());
    }

    @Test
    @DataSet
    public void get() {
        Billboard e = repository.get(99);
        System.out.println(e);
        assertEquals(99, e.getId());
        assertEquals(2, e.getCityId());
        assertEquals("Пр. Шамиля 4", e.getAddress());
        assertEquals(1, e.getTypeId());
        assertEquals(true, e.isLight());
        assertEquals(new BigDecimal("100.00"), e.getRent());
        assertEquals(1, e.getOwnerId());
        assertEquals(2, e.getAgentId());
    }

    @Test
    @DataSet
    @ExpectedDataSet
    public void update() {
        Billboard e = repository.get(99);
        e.setRent(new BigDecimal("130"));
        txTemplate.execute(transactionStatus -> repository.update(e));
    }

    @Test
    @DataSet
    public void remove() {
        assertNotNull(repository.get(99));
        txTemplate.execute(transactionStatus -> repository.remove(99));
        assertNull(repository.get(99));
    }

    @Test
    @DataSet
    public void getAll() {
        List<Billboard> list = repository.getAll();
        assertEquals(4, list.size());
        assertEquals(96, list.get(0).getId());
        assertEquals(97, list.get(1).getId());
        assertEquals(98, list.get(2).getId());
        assertEquals(99, list.get(3).getId());
    }
}
