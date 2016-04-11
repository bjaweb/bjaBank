package com.bja.bapps.bjaBank.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bja.bapps.bjaBank.dao.IBanqueDao;
import com.bja.bapps.bjaBank.entities.Client;
import com.bja.bapps.bjaBank.entities.Compte;
import com.bja.bapps.bjaBank.entities.Employe;
import com.bja.bapps.bjaBank.entities.Groupe;
import com.bja.bapps.bjaBank.entities.Operation;
import com.bja.bapps.bjaBank.entities.Retrait;
import com.bja.bapps.bjaBank.entities.Versement;


/**
 * 
 * si un exeption est levé dans une methode, un rollback est appellé
 *
 */
@Transactional // spring gere les transactions pour toutes les methodes
@Service
public class BanqueMetierImpl implements IBanqueMetier {
	
	@Autowired
	private IBanqueDao dao;
	
	
//
//	public void setDao(IBanqueDao dao) {
//		this.dao = dao;
//		
//	}

	
	public Client addClient(Client C) {
		return dao.addClient(C);
	}
	
	public Employe addEmploye(Employe e, Long codeSup) {		
		return dao.addEmploye(e, codeSup);
	}

//	@Transactional// gestion de transaction sur une methode
	public Groupe addGroupe(Groupe g) {
		return dao.addGroupe(g);
	}

	public void addEmployeToGroupe(Long codeEmp, Long codeGr) {
		dao.addEmployeToGroupe(codeEmp, codeGr);
		
	}

	public Compte addCompte(Compte cp, Long codeCli, Long codeEmp) {
		return dao.addCompte(cp, codeCli, codeEmp);
	}

	public void verser(double mt, String cpte, Long codeEmp) {
		dao.addOperation(new Versement(new Date(),mt), cpte, codeEmp);
		Compte cp = dao.consulterCompte(cpte);
		cp.setSolde(cp.getSolde()+mt);
	}

	public void retirer(double mt, String cpte, Long codeEmp) {
		dao.addOperation(new Retrait(new Date(),mt), cpte, codeEmp);
		Compte cp = dao.consulterCompte(cpte);
		cp.setSolde(cp.getSolde()-mt);
	}

	public void virement(double mt, String cpte1, String cpte2, Long codeEmp) {
		dao.addOperation(new Retrait(new Date(),mt), cpte1, codeEmp);
		dao.addOperation(new Versement(new Date(),mt), cpte2, codeEmp);		
		
	}

	public Compte consulterCompte(String codeC) {		
		return dao.consulterCompte(codeC);
	}

	public Employe getEmploye(Long codeEmploye) {
		// TODO Auto-generated method stub
		return dao.getEmploye(codeEmploye);
	}

	public List<Operation> consulterOperations(String codeCpte) {
		// TODO Auto-generated method stub
		return dao.consulterOperations(codeCpte);
	}

	public Client consulterClient(Long codeCli) {
		// TODO Auto-generated method stub
		return dao.consulterClient(codeCli);
	}

	public List<Client> consulterClients(String mc) {
		// TODO Auto-generated method stub
		return dao.consulterClients(mc);
	}

	public List<Compte> getComptesByClient(Long codeClient) {
		// TODO Auto-generated method stub
		return dao.getComptesByClient(codeClient);
	}

	public List<Compte> getComptesByEmploye(Long codeEmp) {
		// TODO Auto-generated method stub
		return dao.getComptesByEmploye(codeEmp);
	}

	public List<Employe> ConsulterEmployes() {
		// TODO Auto-generated method stub
		return dao.ConsulterEmployes();
	}

	public List<Groupe> ConsulterGroupes() {
		// TODO Auto-generated method stub
		return dao.ConsulterGroupes();
	}

	public List<Employe> getEmployesByGroupe(Long codeGroupe) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
