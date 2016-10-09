package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.BillboardSide;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBeanByType;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BillboardSideRepositoryJpaImplTest extends AbstractRepositoryTest {
    @SpringBeanByType
    private BillboardSideRepositoryJpaImpl repository;

    @Test
    @DataSet
    @ExpectedDataSet
    public void addWithGenerationId() {
        BillboardSide e = new BillboardSide(100, "A", BigDecimal.TEN);
        BillboardSide e2 = txTemplate.execute(transactionStatus -> repository.add(e));
        assertNotEquals(0, e2.getId());
    }

    @Test
    @DataSet
    public void get() {
        BillboardSide e = repository.get(99);
        System.out.println(e);
        assertEquals(99, e.getId());
        assertEquals("B", e.getName());
    }

    @Test
    @DataSet
    @ExpectedDataSet
    public void update() {
        BillboardSide e = repository.get(99);
        e.setRent(new BigDecimal("11.00"));
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
        List<BillboardSide> list = repository.getAll();
        assertEquals(4, list.size());
        assertEquals(96, list.get(0).getId());
        assertEquals(97, list.get(1).getId());
        assertEquals(98, list.get(2).getId());
        assertEquals(99, list.get(3).getId());
    }

    @Test
    @DataSet
    public void getByBillboard() {
        List<BillboardSide> list = repository.getByBillboard(2);
        assertEquals(2, list.size());
        assertEquals(98, list.get(0).getId());
        assertEquals(99, list.get(1).getId());
    }
}
