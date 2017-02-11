package com.sotas.billboard05.controller;

import com.sotas.billboard05.AccessError;
import com.sotas.billboard05.AuthUser;
import com.sotas.billboard05.repository.AgentRepository;
import com.sotas.billboard05.service.*;
import org.junit.Before;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBeanByType;

public class ContractControllerTest extends AbstractControllerTest {
    @SpringBeanByType
    ContractService contractService;
    @SpringBeanByType
    AgentRepository agentRepository;
    @SpringBeanByType
    TimetableService timetableService;
    @SpringBeanByType
    BillboardSideService billboardSideService;
    @SpringBeanByType
    BillboardService billboardService;

    ContractController controller;

    @Test
    @DataSet
    @ExpectedDataSet
    public void accept() {
        controller.accept(1);
    }

    @Test(expected = AccessError.class)
    @DataSet
    public void acceptErrorWrongAgent() {
        new ContractController(contractService, () -> new AuthUser(agentRepository.get(9991)), timetableService, billboardSideService, billboardService).accept(1);
    }

    @Test
    @DataSet
    @ExpectedDataSet
    public void reject() {
        controller.reject(1);
    }

    @Before
    public void init() {
        controller = new ContractController(contractService, () -> new AuthUser(agentRepository.get(999)), timetableService, billboardSideService, billboardService);
    }
}
