package com.sotas.billboard05.service;

import com.sotas.billboard05.entity.Owner;
import org.junit.Test;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBeanByName;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class OwnerServiceTest extends AbstractServiceTest {
    @SpringBeanByName
    private OwnerService ownerServiceImpl;

    @Test
    @ExpectedDataSet("unitils/OwnerRepositoryJpaImplTest.addWithGenerationIdAndCreateFields-result.xml")
    void add() {
        Owner e = new Owner("new_name", "new_phone", 1);
        e = ownerServiceImpl.add(e);
        assertNotEquals(0, e.getId());
        assertNotNull(e.getCreateDate());
    }
}
