package com.sotas.billboard05.controller;

import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;

@SpringApplicationContext({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/mvc-dispatcher-servlet.xml", "test-repository-datasource-context.xml"})
public abstract class AbstractControllerTest extends UnitilsJUnit4 {

}
