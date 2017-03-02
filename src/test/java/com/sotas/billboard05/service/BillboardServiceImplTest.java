package com.sotas.billboard05.service;

import com.sotas.billboard05.dto.BillboardDto;
import com.sotas.billboard05.entity.Billboard;
import com.sotas.billboard05.entity.BillboardSide;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBeanByName;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

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

    @Test
    @DataSet
    public void getBillboardsByCity() {
        List<BillboardDto> list = billboardServiceImpl.getListByCity(5);
        assertEquals(2, list.size());

        assertEquals("Пр. Шамиля 2", list.get(0).getE().getAddress());
        assertEquals("Пр. Шамиля 4", list.get(1).getE().getAddress());

        assertEquals("Москва", list.get(0).getCity().getName());
        assertEquals("Москва", list.get(1).getCity().getName());

        assertEquals("Барак Обама", list.get(0).getAgent().getName());
        assertEquals("Билл Клинтон", list.get(1).getAgent().getName());

        assertEquals("Тип2", list.get(0).getType().getName());
        assertEquals("Тип2", list.get(1).getType().getName());

        assertEquals("Формат1", list.get(0).getFormat().getName());
        assertEquals("Формат1", list.get(1).getFormat().getName());
    }

    @Test
    @ExpectedDataSet
    public void addBillboard() throws IOException {
        List<BillboardSide> bbSideList = new ArrayList<>();
        bbSideList.add(new BillboardSide(1, "name1", new BigDecimal("100.00"), 3));
        bbSideList.add(new BillboardSide(1, "name2", new BigDecimal("100.00"), 3));
        File dir = new File("/tmp/billboard-test");
        FileUtils.deleteDirectory(dir);
        assertFalse(dir.exists());
        dir.mkdir();
        Map<String, byte[]> imgs = new HashMap<>();
        imgs.put("0.png", new byte[]{0x61,0x62,0x63});
        imgs.put("0.jpg", new byte[]{0x64,0x65,0x66});
        imgs.put("1.jpg", new byte[]{0x67,0x68,0x69});
        Billboard bb = new Billboard(1, "address", 1, 1, true, "123,123", 1, 1, 100, 100);
        billboardServiceImpl.add(bb, bbSideList, dir.getAbsolutePath(), imgs
        );
        assertTrue(new File(dir.getAbsolutePath() + "/" + bb.getId() + "/0.png").exists());
        assertTrue(new File(dir.getAbsolutePath() + "/" + bb.getId() + "/0.jpg").exists());
        assertTrue(new File(dir.getAbsolutePath() + "/" + bb.getId() + "/1.jpg").exists());
    }
}
