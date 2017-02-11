package com.sotas.billboard05.service;

import com.sotas.billboard05.dto.ContractDto;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringBeanByType;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ContractServiceTest extends AbstractServiceTest {
    @SpringBeanByType
    private ContractService contractService;
    @Test
    @DataSet
    public void getByAgentId() {
        List<ContractDto> contracts = contractService.getByAgentId(999, 2016, 10);
        assertEquals(4, contracts.size());
        assertEquals(contracts.get(0).getE().getClientComment(), "Комментарии клиента1");
        assertEquals(contracts.get(1).getE().getClientComment(), "Комментарии клиента2");
        assertEquals(contracts.get(2).getE().getClientComment(), "Комментарии клиента3");
        assertEquals(contracts.get(3).getE().getClientComment(), "Комментарии клиента4");

        assertEquals(contracts.get(0).getE().getTimetableId(), 10);
        assertEquals(contracts.get(1).getE().getTimetableId(), 60);
        assertEquals(contracts.get(2).getE().getTimetableId(), 70);
        assertEquals(contracts.get(3).getE().getTimetableId(), 120);

        assertEquals(contracts.get(0).getTimetable().getRent().toString(), "1000.00");
        assertEquals(contracts.get(1).getTimetable().getRent().toString(), "2000.00");
        assertEquals(contracts.get(2).getTimetable().getRent().toString(), "3000.00");
        assertEquals(contracts.get(3).getTimetable().getRent().toString(), "4000.00");

        assertEquals(contracts.get(0).getBillboardSide().getName(), "имя 1");
        assertEquals(contracts.get(1).getBillboardSide().getName(), "имя 1");
        assertEquals(contracts.get(2).getBillboardSide().getName(), "имя 2");
        assertEquals(contracts.get(3).getBillboardSide().getName(), "имя 2");

        assertEquals(contracts.get(0).getBillboard().getAddress(), "адрес 1");
        assertEquals(contracts.get(1).getBillboard().getAddress(), "адрес 1");
        assertEquals(contracts.get(2).getBillboard().getAddress(), "адрес 2");
        assertEquals(contracts.get(3).getBillboard().getAddress(), "адрес 2");
    }

}
