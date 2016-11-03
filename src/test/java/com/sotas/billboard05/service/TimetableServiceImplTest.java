package com.sotas.billboard05.service;

import com.sotas.billboard05.dto.TimetableSideDto;
import com.sotas.billboard05.entity.Timetable;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringBeanByType;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TimetableServiceImplTest extends AbstractServiceTest {
    @SpringBeanByType
    TimetableService service;
    @Test
    @DataSet
    public void getForSurface() {
        TimetableSideDto r = service.getByBillboardSide(
                2016, //beginYear
                11, //beginMonth
                1 //sideId
        );
        assertEquals(new BigDecimal("100.00"), r.get(0, 2016, 11).getRent());
        assertEquals(Timetable.Status.OPEN, r.get(0, 2016, 11).getStatus());
        assertEquals(new BigDecimal("110.00"), r.get(0, 2017, 0).getRent());
        assertEquals(Timetable.Status.OPEN, r.get(0, 2017, 0).getStatus());
        assertEquals(new BigDecimal("120.00"), r.get(0, 2017, 1).getRent());
        assertEquals(Timetable.Status.CLOSE, r.get(0, 2017, 1).getStatus());

        assertEquals(new BigDecimal("100.00"), r.get(1, 2016, 11).getRent());
        assertEquals(Timetable.Status.OPEN, r.get(0, 2016, 11).getStatus());
        assertEquals(new BigDecimal("210.00"), r.get(1, 2017, 0).getRent());
        assertEquals(Timetable.Status.OPEN, r.get(0, 2017, 0).getStatus());
        assertEquals(new BigDecimal("220.00"), r.get(1, 2017, 1).getRent());
        assertEquals(Timetable.Status.CLOSE, r.get(0, 2017, 1).getStatus());

        assertEquals(new BigDecimal("100.00"), r.get(2, 2016, 11).getRent());
        assertEquals(Timetable.Status.OPEN, r.get(0, 2016, 11).getStatus());
        assertEquals(new BigDecimal("310.00"), r.get(2, 2017, 0).getRent());
        assertEquals(Timetable.Status.OPEN, r.get(0, 2017, 0).getStatus());
        assertEquals(new BigDecimal("320.00"), r.get(2, 2017, 1).getRent());
        assertEquals(Timetable.Status.CLOSE, r.get(0, 2017, 1).getStatus());
    }
}
