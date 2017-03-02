package com.sotas.billboard05.service;

import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;

@SpringApplicationContext({"test-root-context.xml", "test-repository-datasource-context.xml"})
public abstract class AbstractServiceTest extends UnitilsJUnit4 {
}
