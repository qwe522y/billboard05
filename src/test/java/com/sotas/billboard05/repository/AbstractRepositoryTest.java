package com.sotas.billboard05.repository;

import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.support.TransactionTemplate;
import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;
import org.unitils.spring.annotation.SpringBeanByType;

@SpringApplicationContext("app-context.xml")
public abstract class AbstractRepositoryTest extends UnitilsJUnit4 {
    @SpringBeanByType
    TransactionTemplate txTemplate;
}
