package com.bja.bapps.bjaBank;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:/applicationContext.xml","classpath:/spring-config-bappsSocleDao.xml"})
public abstract class BaseTest {

}
