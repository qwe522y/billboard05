package com.sotas.billboard05.repository;

import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.support.TransactionTemplate;
import org.unitils.UnitilsJUnit4;

public abstract class AbstractRepositoryTest extends UnitilsJUnit4 {
    static ApplicationContext context;
    TransactionTemplate txTemplate;
    @BeforeClass
    public static void basicBeforeClass() {
        context = new ClassPathXmlApplicationContext("/app-context.xml");
    }

    @Before
    public void basicBefore() {
        txTemplate = context.getBean(TransactionTemplate.class);
    }
}
