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

        assertEquals("Пр. Шамиля 1", list.get(0).getE().getAddress());
        assertEquals("Пр. Шамиля 2", list.get(1).getE().getAddress());

        assertEquals("Берлин", list.get(0).getCity().getName());
        assertEquals("Москва", list.get(1).getCity().getName());

        assertEquals("Скорпион", list.get(0).getOwner().getName());
        assertEquals("Скорпион", list.get(1).getOwner().getName());

        assertEquals("Барак Обама", list.get(0).getAgent().getName());
        assertEquals("Барак Обама", list.get(1).getAgent().getName());

        assertEquals("Тип1", list.get(0).getType().getName());
        assertEquals("Тип2", list.get(1).getType().getName());

        assertEquals("Формат2", list.get(0).getFormat().getName());
        assertEquals("Формат1", list.get(1).getFormat().getName());

    }
}
