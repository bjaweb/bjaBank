package com.bja.bapps.bjaBank.dao;

import java.util.List;

import com.bja.bapps.bjaBank.entities.Client;
import com.bja.bapps.bjaBank.entities.Compte;
import com.bja.bapps.bjaBank.entities.Employe;
import com.bja.bapps.bjaBank.entities.Groupe;
import com.bja.bapps.bjaBank.entities.Operation;

public interface IBanqueDao {
	
	/**
	 * ajout
	 */
	
	public Client addClient(Client C);
	public Employe addEmploye(Employe e, Long codeSup);
	
	public Groupe addGroupe(Groupe g);
	
	public void addEmployeToGroupe(Long codeEmp, Long codeGr);
	public Compte addCompte(Compte cp, Long codeCli, Long codeEmp);
	public Operation addOperation(Operation op, String codeCpte, Long codeEmp); 
	
	
	
	/**
	 * consultation	  
	 */
	
	// consulter les comptes 
	public Compte consulterCompte(String codeC);
	public Employe getEmploye(Long codeEmploye);
	
	public List<Operation> consulterOperations (String codeCpte);
	
	// consulation par id, par nom
	public Client consulterClient(Long codeCli);
	/**
	 * recherche de client par mot clés
	 * @param mc : mot clé pour trouver des clients
	 * @return la liste de clients correspondant au mot clé
	 */
	public List<Client> consulterClients(String mc);
	
	
	public List<Compte> getComptesByClient (Long codeClient);	
	public List<Compte> getComptesByEmploye (Long codeEmp);
	
	public List<Employe> ConsulterEmployes ();
	public List<Groupe> ConsulterGroupes ();
	public List<Employe> getEmployesByGroupe(Long codeGroupe);

}
