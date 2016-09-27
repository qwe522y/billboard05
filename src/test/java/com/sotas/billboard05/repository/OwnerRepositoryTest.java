package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.Owner;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBeanByType;

import java.util.List;

import static org.junit.Assert.*;

public class OwnerRepositoryTest extends AbstractRepositoryTest {
    @SpringBeanByType
    private OwnerRepositoryJpaImpl repository;

    @Test
    @ExpectedDataSet
    public void addWithGenerationIdAndCreateFields() {
        final Owner e = new Owner("newtname", "newtphone");
        Owner e2 = txTemplate.execute(transactionStatus -> repository.add(e));
        assertNotEquals(0, e2.getId());
        assertNotNull(e2.getCreateDate());
    }

    @Test
    @DataSet
    public void get() {
        Owner e = repository.get(99);
        System.out.println(e);
        assertEquals("tname", e.getName());
    }

    @Test
    @DataSet
    @ExpectedDataSet
    public void update() {
        Owner e = repository.get(99);
        e.setPhone("newtphone");
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
        List<Owner> list = repository.getAll();
        assertEquals(3, list.size());
        assertEquals(97, list.get(0).getId());
        assertEquals(98, list.get(1).getId());
        assertEquals(99, list.get(2).getId());
    }
}
