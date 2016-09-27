package com.sotas.billboard05.service;

import com.sotas.billboard05.entity.Billboard;
import com.sotas.billboard05.repository.BillboardRepositoryJpaImpl;
import org.junit.Before;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringBeanByType;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BillboardServiceImplTest extends AbstractServiceTest {
    @SpringBeanByType
    private BillboardRepositoryJpaImpl billboardRepository;
    private BillboardServiceImpl service;
    @Test
    @DataSet
    public void getBillboardsByCity() {
        List<Billboard> list = service.getListByCity(1);
        assertEquals(97, list.get(0).getId());
        assertEquals(99, list.get(1).getId());
        assertEquals(2, list.size());
    }

    @Before
    public void befor() {
        service = new BillboardServiceImpl(billboardRepository);
    }
}
