package com.sotas.billboard05.repository;

import org.springframework.transaction.support.TransactionTemplate;
import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

@SpringApplicationContext({"file:src/main/webapp/WEB-INF/spring/root-context.xml", "test-repository-datasource-context.xml"})
public abstract class AbstractRepositoryTest extends UnitilsJUnit4 {
    @SpringBeanByType
    TransactionTemplate txTemplate;
}
