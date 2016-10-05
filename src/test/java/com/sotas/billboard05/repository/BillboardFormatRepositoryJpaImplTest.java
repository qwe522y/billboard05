package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.BillboardFormat;
import org.junit.Test;
import org.springframework.stereotype.Repository;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringBeanByType;

import java.util.List;

import static org.junit.Assert.assertEquals;

@Repository
public class BillboardFormatRepositoryJpaImplTest extends AbstractRepositoryTest {
    @SpringBeanByType
    private BillboardFormatRepositoryJpaImpl repository;

    @Test
    @DataSet
    public void get() {
        BillboardFormat e = repository.get(99);
        System.out.println(e);
        assertEquals("Статика", e.getName());
    }

    @Test
    @DataSet
    public void getAll() {
        List<BillboardFormat> list = repository.getAll();
        assertEquals(2, list.size());
        assertEquals("Динамика", list.get(0).getName());
        assertEquals("Статика", list.get(1).getName());
    }
}
