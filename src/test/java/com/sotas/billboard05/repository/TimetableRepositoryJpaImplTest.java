package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.Timetable;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringBean;

import java.math.BigDecimal;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TimetableRepositoryJpaImplTest extends AbstractRepositoryTest {
    @SpringBean("timetableRepositoryJpaImpl")
    private TimetableRepository repository;

    @Test
    @DataSet
    public void getByBillboardSideSortedByYearAndMonth() {
        List<Timetable> list = repository.getByBillboardSideAndBeginDate(98, 2016, 10);
        for(Timetable e : list) {
            System.out.println(e);
            assertEquals(e.getRent(), new BigDecimal("100.00"));
        }
        assertEquals(18, list.size());
        for(int i=0; i<6; i++) assertEquals(10, list.get(i).getMonth());
        for(int i=6; i<12; i++) assertEquals(11, list.get(i).getMonth());
        for(int i=12; i<18; i++) assertEquals(0, list.get(i).getMonth());
    }
}
