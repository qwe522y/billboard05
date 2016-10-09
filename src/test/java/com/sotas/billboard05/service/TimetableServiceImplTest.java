package com.sotas.billboard05.service;

import com.sotas.billboard05.entity.Billboard;
import com.sotas.billboard05.entity.Timetable;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TimetableServiceImplTest {
    TimetableServiceImpl service = new TimetableServiceImpl(null);
    @Test
    public void filterForSurface() {
        Billboard bb = new Billboard();
        //bb.setRent(BigDecimal.TEN);
        //bb.setSideNum(2);
        //bb.setSurfaceNumPerSide(2);
        List<Timetable> list = new ArrayList<>();
        list.add(new Timetable(99, 0, 0, 2016, 10, new BigDecimal(1)));
        list.add(new Timetable(99, 0, 1, 2016, 10, new BigDecimal(2)));
        list.add(new Timetable(99, 1, 0, 2016, 10, new BigDecimal(3)));
        list.add(new Timetable(99, 1, 1, 2016, 10, new BigDecimal(4)));

        list.add(new Timetable(99, 0, 0, 2016, 11, new BigDecimal(5)));
        list.add(new Timetable(99, 0, 1, 2016, 11, new BigDecimal(6)));
        list.add(new Timetable(99, 1, 0, 2016, 11, new BigDecimal(7)));
        list.add(new Timetable(99, 1, 1, 2016, 11, new BigDecimal(8)));

        list.add(new Timetable(99, 0, 0, 2017, 0, new BigDecimal(9)));
        list.add(new Timetable(99, 0, 1, 2017, 0, new BigDecimal(10)));
        list.add(new Timetable(99, 1, 0, 2017, 0, new BigDecimal(11)));
        list.add(new Timetable(99, 1, 1, 2017, 0, new BigDecimal(12)));

        List<Timetable> l = service.filterForSurface(list, 2016, 10, 3, 99, 1, 1);
        assertEquals(3, l.size());
        assertEquals(new BigDecimal(4), l.get(0).getRent());
        assertEquals(new BigDecimal(8), l.get(1).getRent());
        assertEquals(new BigDecimal(12), l.get(2).getRent());
    }
}
