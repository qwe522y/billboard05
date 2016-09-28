package com.sotas.billboard05.service;

import com.sotas.billboard05.dto.BillboardDto;
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
    public void getBillboardsByAgent() {
        List<BillboardDto> list = service.getListByAgent(1);
        assertEquals(4, list.size());

        assertEquals("Боль", list.get(0).getE().getName());
        assertEquals("Паника", list.get(1).getE().getName());
        assertEquals("Тревога", list.get(2).getE().getName());
        assertEquals("Страх", list.get(3).getE().getName());

        assertEquals("Берлин", list.get(0).getCity().getName());
        assertEquals("Махачкала", list.get(1).getCity().getName());
        assertEquals("Берлин", list.get(2).getCity().getName());
        assertEquals("Махачкала", list.get(3).getCity().getName());

        assertEquals("Саб-зиро", list.get(0).getOwner().getName());
        assertEquals("Саб-зиро", list.get(0).getOwner().getName());
        assertEquals("Скорпион", list.get(0).getOwner().getName());
        assertEquals("Скорпион", list.get(0).getOwner().getName());

        assertEquals("Растяжка", list.get(0).getCity().getName());
        assertEquals("Щит", list.get(1).getCity().getName());
        assertEquals("Растяжка", list.get(2).getCity().getName());
        assertEquals("Щит", list.get(3).getCity().getName());

        assertEquals("Тинки", list.get(0).getCity().getName());
        assertEquals("Тинки", list.get(1).getCity().getName());
        assertEquals("Брейн", list.get(2).getCity().getName());
        assertEquals("Брейн", list.get(3).getCity().getName());
    }

    @Before
    public void before() {
        service = new BillboardServiceImpl(billboardRepository);
    }
}
