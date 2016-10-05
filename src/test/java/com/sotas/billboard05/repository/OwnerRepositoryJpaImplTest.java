package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.Owner;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBeanByType;

import java.util.List;

import static org.junit.Assert.*;

public class OwnerRepositoryJpaImplTest extends AbstractRepositoryTest {
    @SpringBeanByType
    private OwnerRepositoryJpaImpl repository;

    @Test
    @ExpectedDataSet
    public void addWithGenerationIdAndCreateFields() {
        final Owner e = new Owner("new_name", "new_phone", 1);
        Owner e2 = txTemplate.execute(transactionStatus -> repository.add(e));
        assertNotEquals(0, e2.getId());
        assertNotNull(e2.getCreateDate());
    }

    @Test
    @DataSet
    public void get() {
        Owner e = repository.get(99);
        System.out.println(e);
        assertEquals("Имя4", e.getName());
    }

    @Test
    @DataSet
    @ExpectedDataSet
    public void update() {
        Owner e = repository.get(99);
        e.setPhone("new_phone");
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
        assertEquals(4, list.size());
        assertEquals(96, list.get(0).getId());
        assertEquals(97, list.get(1).getId());
        assertEquals(98, list.get(2).getId());
        assertEquals(99, list.get(3).getId());

        assertEquals("Имя1", list.get(0).getName());
        assertEquals("Имя2", list.get(1).getName());
        assertEquals("Имя3", list.get(2).getName());
        assertEquals("Имя4", list.get(3).getName());
    }

    @Test
    @DataSet
    public void getByAgent(){
        List<Owner> owners = repository.getByAgent(1);
        assertEquals(96, owners.get(0).getId());
        assertEquals("Имя1", owners.get(0).getName());
        assertEquals(98, owners.get(1).getId());
        assertEquals("Имя3", owners.get(1).getName());
    }
}
