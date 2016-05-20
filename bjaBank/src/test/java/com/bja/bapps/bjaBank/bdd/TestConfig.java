package com.bja.bapps.bjaBank.bdd;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bja.bapps.bjaBank.BaseTest;
import com.bja.bapps.bjaBank.entities.Client;
import com.bja.bapps.bjaBank.entities.Compte;
import com.bja.bapps.bjaBank.entities.CompteCourant;
import com.bja.bapps.bjaBank.entities.CompteEpargne;
import com.bja.bapps.bjaBank.entities.Employe;
import com.bja.bapps.bjaBank.entities.Groupe;
import com.bja.bapps.bjaBank.metier.IBanqueMetier;
import static org.junit.Assert.*;

public class TestConfig extends BaseTest{
	
	
	@Autowired
    private IBanqueMetier metier;
	
	@Test
	public void test1(){
		metier.addEmploye(new Employe("Garfield","Pierre",new Date()), null);
		metier.addEmploye(new Employe("Garfield","Rose",new Date()), 1L);
		
		Client client = new Client("JEAN","Jean", "5, rue du mont moulin 95411 zertuin");
		Client client2 = new Client("PERO","Marc", "5, rue du mont moulin 95411 zertuin");
		
		
		metier.addClient(client);
		metier.addClient(client2);
//		
		Client c = metier.consulterClient(1L); 

//		metier.addGroupe(new Groupe("direction"));
//		
//		metier.addCompte(new CompteCourant("CC1",new Date(),9000,8000), c.getCodeClient(), 2L);
//		metier.addCompte(new CompteEpargne("CE1",new Date(),10000,5.5), c.getCodeClient(), 2L);
		System.out.println("client "+c.getCodeClient());
		
		
		CompteCourant compteCourant = new CompteCourant("35548d", 856, 0);
		Compte compteEpargne = new CompteEpargne("LEP7785", 55227, 8);
		metier.addCompte(compteCourant , 1L, 1L);
		metier.addCompte(compteEpargne , 1L, 1L);
		
		assertNotNull(c);
		
		
	}

}
