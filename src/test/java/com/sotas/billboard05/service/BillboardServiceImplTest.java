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
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
        dir.mkdirs();
        Billboard bb = new Billboard(1, "address", 1, 1, true, "123,123", 1, 1, 100, 100);
        billboardServiceImpl.add(bb, bbSideList, new byte[]{(byte) 0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A, 0x00}, new byte[][]{{(byte) 0xFF, (byte)0xD8, 0x01},{(byte)0xFF, (byte)0xD8, 0x02}});

        File f = new File(dir.getAbsolutePath() + "/" + bb.getId() + "/0.png");
        assertTrue(f.exists());
        assertEquals(new FileInputStream(f).read(), 0x89);

        f = new File(dir.getAbsolutePath() + "/" + bb.getId() + "/0.jpg");
        assertTrue(f.exists());
        FileInputStream fis = new FileInputStream(f);
        assertEquals(fis.read(), 0xFF);
        assertEquals(fis.read(), 0xD8);
        assertEquals(fis.read(), 0x01);

        f = new File(dir.getAbsolutePath() + "/" + bb.getId() + "/1.jpg");
        fis = new FileInputStream(f);
        assertTrue(f.exists());
        assertEquals(fis.read(), 0xFF);
        assertEquals(fis.read(), 0xD8);
        assertEquals(fis.read(), 0x02);
    }
}
