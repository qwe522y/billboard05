package com.sotas.billboard05.controller;

import com.sotas.billboard05.AuthUser;
import com.sotas.billboard05.entity.Owner;
import com.sotas.billboard05.repository.OwnerRepository;
import com.sotas.billboard05.service.AgentService;
import com.sotas.billboard05.service.AuthUserService;
import com.sotas.billboard05.service.OwnerService;
import org.junit.Before;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringBeanByType;

import static org.junit.Assert.assertEquals;

public class OwnerCrudControllerTest extends AbstractControllerTest {
    private OwnerCrudController controller;
    @SpringBeanByType
    private OwnerService ownerService;
    @SpringBeanByType
    private OwnerRepository repository;
    @SpringBeanByType
    private AgentService agentService;

    @Test
    @DataSet
    public void editOwner() {
        Owner owner = new Owner("new name", "+79999999999", 0);
        controller.editOwner(1, owner);
        assertEquals("new name", ownerService.get(1).getName());
        assertEquals("+79999999999", ownerService.get(1).getPhone());
        assertEquals(101, ownerService.get(1).getAgentId());
    }

    @Test
    @DataSet
    public void editOwnerFailWhenAgentIdWrong() {
        Owner owner = new Owner("new name", "+79999999999", 0);
        String err = null;
        try {
            controller.editOwner(2, owner);
        } catch (RuntimeException e) {
            err = e.getMessage();
        }
        assertEquals(err, "owner.agentId=102 authUser.agent.id=101");
    }

    @Test
    @DataSet
    public void Owner() {
        controller.addOwner(new Owner("name", "+79999999999", 0));
        Owner owner = repository.getAll().get(1);
        assertEquals("name", owner.getName());
        assertEquals("+79999999999", owner.getPhone());
        assertEquals(101, owner.getAgentId());
    }

    @Before
    public void init() {
        controller = new OwnerCrudController(new AuthUserService() {
            @Override
            public AuthUser getAuthUser() {
                return new AuthUser(agentService.getByLogin("123@001"));
            }
        }, ownerService);
    }
}
