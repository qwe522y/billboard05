package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.Billboard;
import com.sotas.billboard05.entity.BillboardSide;
import com.sotas.billboard05.entity.Contract;
import com.sotas.billboard05.entity.Timetable;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringBeanByType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ContractRepositoryJpaImplTest extends AbstractRepositoryTest {
    @SpringBeanByType
    private ContractRepository repository;
    @SpringBeanByType
    private TimetableRepository timetableRepository;
    @SpringBeanByType
    private BillboardSideRepository billboardSideRepository;
    @SpringBeanByType
    private BillboardRepository billboardRepository;
    @Test
    @DataSet
    public void getByTimetableList() {
        List<Billboard> bbList = billboardRepository.getListByAgent(999);
        List<Integer> bbIdList = new ArrayList<>();
        for(Billboard bb : bbList) bbIdList.add(bb.getId());
        assertEquals(2, bbList.size());
        assertEquals(1, bbList.get(0).getId());
        assertEquals(2, bbList.get(1).getId());

        List<BillboardSide> bbSideList = billboardSideRepository.getByBillboard(bbIdList);
        List<Integer> bbSideIdList = new ArrayList<>();
        for(BillboardSide bbSide : bbSideList) bbSideIdList.add(bbSide.getId());
        assertEquals(2, bbSideList.size());
        assertEquals(98, bbSideList.get(0).getId());
        assertEquals(99, bbSideList.get(1).getId());

        List<Timetable> ttList = timetableRepository.getByBillboardSideAndBeginDate(bbSideIdList, 2016, 10);
        List<Contract> contracts = repository.getByTimetableList(ttList);
        assertEquals(4, contracts.size());
        assertEquals(contracts.get(0).getClientComment(), "Комментарии клиента1");
        assertEquals(contracts.get(1).getClientComment(), "Комментарии клиента2");
        assertEquals(contracts.get(2).getClientComment(), "Комментарии клиента3");
        assertEquals(contracts.get(3).getClientComment(), "Комментарии клиента4");

        assertEquals(contracts.get(0).getTimetableId(), 10);
        assertEquals(contracts.get(1).getTimetableId(), 60);
        assertEquals(contracts.get(2).getTimetableId(), 70);
        assertEquals(contracts.get(3).getTimetableId(), 120);
    }
}
