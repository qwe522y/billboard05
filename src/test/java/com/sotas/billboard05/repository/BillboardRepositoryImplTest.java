package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.Billboard;
import org.junit.Test;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.transaction.impl.DefaultUnitilsTransactionManager;
import org.unitils.database.util.TransactionMode;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByName;
import org.unitils.spring.annotation.SpringBeanByType;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BillboardRepositoryImplTest extends AbstractRepositoryTest {
    @SpringBeanByType
    BillboardRepositoryImpl repository;

    @Test
    @ExpectedDataSet
    public void addWithGenerationIdAndCreateFields() {
        final Billboard e = new Billboard(1, "taddress", 1, true, new BigDecimal("100.00"), "123,123,123", 1);
        e.setName("tname");
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
        assertEquals(1, e.getCity());
        assertEquals("taddress", e.getAddress());
        assertEquals(1, e.getType());
        assertEquals(true, e.isLight());
        assertEquals(new BigDecimal("100.00"), e.getRent());
        assertEquals("123,123,123", e.getLocation());
        assertEquals(1, e.getOwnerId());
        assertEquals("tname", e.getName());
        assertNotNull(e.getCreateDate());
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
        txTemplate.execute(transactionStatus -> repository.remove(99));
        assertNull(repository.get(99));
    }

    @Test
    @DataSet
    public void getAll() {
        List<Billboard> list = repository.getAll();
        assertEquals(3, list.size());
        assertEquals(97, list.get(0).getId());
        assertEquals(98, list.get(1).getId());
        assertEquals(99, list.get(2).getId());
    }
}
