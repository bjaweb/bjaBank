package com.bja.bapps.bjaBank.bdd;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bja.bapps.bjaBank.BaseTest;
import com.bja.bapps.bjaBank.entities.Client;
import com.bja.bapps.bjaBank.metier.IBanqueMetier;


public class TestConfig extends BaseTest{
	
	
	@Autowired
    private IBanqueMetier metier;
	
	@Test
	public void test1(){
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml", "spring-config-bappsSocleDao.xml"});
//		IBanqueMetier metier =(IBanqueMetier) context.getBean(IBanqueMetier.class);
		metier.addClient(new Client("Moulin2","Jean", "5, rue du mont moulin 95411 zertuin"));
		
		Client c = metier.consulterClient(1L);
		System.out.println(c.getAdresseClient());
//		metier.addClient(new Client("Moulin2","Jean2", "5, rue du mont moulin 95411 zertuin"));
		
	}

}
