package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.Billboard;
import org.junit.Test;
import org.unitils.dbunit.annotation.ExpectedDataSet;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class BillboardRepositoryImplTest extends AbstractRepositoryTest {
    BillboardRepository repository = context.getBean(BillboardRepositoryImpl.class);
    @Test
    @ExpectedDataSet
    public void addWithGenerationIdAndCreateFields() {
        final Billboard e = new Billboard(1, "taddress", 1, true, new BigDecimal("100.00"), "123,123,123", 1);
        e.setName("tname");
        Billboard e2 = txTemplate.execute(transactionStatus -> repository.add(e));
        assertNotEquals(0, e2.getId());
        assertNotNull(e2.getCreateDate());
    }
}
