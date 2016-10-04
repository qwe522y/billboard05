package com.sotas.billboard05.service;

import com.sotas.billboard05.dto.BillboardDto;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringBeanByName;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BillboardServiceImplTest extends AbstractServiceTest {
    @SpringBeanByName
    private BillboardService billboardServiceImpl;

    @Test
    @DataSet
    public void getBillboardsByAgent() {
        List<BillboardDto> list = billboardServiceImpl.getListByAgent(1);
        assertEquals(2, list.size());

        assertEquals("Берлин", list.get(0).getCity().getName());
        assertEquals("Москва", list.get(1).getCity().getName());

        assertEquals("Скорпион", list.get(0).getOwner().getName());
        assertEquals("Скорпион", list.get(1).getOwner().getName());

        assertEquals("Барак Обама", list.get(0).getAgent().getName());
        assertEquals("Барак Обама", list.get(1).getAgent().getName());

        assertEquals(1, list.get(0).getType().getSurface());
        assertEquals(2, list.get(1).getType().getSurface());
    }
}
