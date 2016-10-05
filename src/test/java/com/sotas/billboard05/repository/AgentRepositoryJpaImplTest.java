package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.Agent;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBeanByType;

import java.util.List;

import static org.junit.Assert.*;

public class AgentRepositoryJpaImplTest extends AbstractRepositoryTest {
    @SpringBeanByType
    AgentRepositoryJpaImpl repository;

    @Test
    @DataSet
    @ExpectedDataSet
    public void addWithGenerationIdAndCreateFields() {
        final Agent e = new Agent("login4", "dc829bf0d79e690c59cee708b527e6b7", "Четвертый", "Калинина 4", "+7111", null);
        Agent e2 = txTemplate.execute(transactionStatus -> repository.add(e));
        assertNotEquals(0, e2.getId());
        assertNotNull(e2.getCreateDate());
    }

    @Test
    @DataSet
    public void get() {
        Agent e = repository.get(99);
        assertEquals(99, e.getId());
        assertEquals("login99", e.getLogin());
    }

    @Test
    @DataSet
    public void getByLogin() {
        Agent e = repository.getByLogin("login99");
        assertEquals(99, e.getId());
        assertEquals("login99", e.getLogin());
    }

    @Test
    @DataSet
    @ExpectedDataSet
    public void update() {
        Agent e = repository.get(99);
        e.setName("Новое имя");
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
        List<Agent> list = repository.getAll();
        assertEquals(3, list.size());
        assertEquals(97, list.get(0).getId());
        assertEquals(98, list.get(1).getId());
        assertEquals(99, list.get(2).getId());
    }


}
