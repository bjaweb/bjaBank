package com.bja.bapps.bjaBank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bja.bapps.bjaBank.entities.Client;
import com.bja.bapps.bjaBank.entities.Compte;
import com.bja.bapps.bjaBank.entities.Employe;
import com.bja.bapps.bjaBank.entities.Groupe;
import com.bja.bapps.bjaBank.entities.Operation;

@Repository
public class BanqueDaoImpl implements IBanqueDao{
	
	@PersistenceContext // transaction gerer par spring
	public EntityManager em;
	
	
	public Client addClient(Client c) {
		em.persist(c);
		return c;
	}

	public Employe addEmploye(Employe e, Long codeSup) {
		if(codeSup != null){
			Employe employeSup = em.find(Employe.class, codeSup);
			e.setEmployeSup(employeSup);
		}
		em.persist(e);
		return null;
	}

	public Groupe addGroupe(Groupe g) {
		em.persist(g);
		return g;
	}

	public void addEmployeToGroupe(Long codeEmp, Long codeGr) {
		if(codeGr != null && codeEmp != null){
			Employe employe = em.find(Employe.class, codeEmp);
			Groupe groupe = em.find(Groupe.class, codeGr);
			
			// relation many many bidirectionnelle  : on met à jour les deux objets
			groupe.getEmployes().add(employe);
			employe.getGroupes().add(groupe);
			
			// apparemment pas besoin de persister
//			em.merge(groupe);
			
		}
		
	}

	public Compte addCompte(Compte cp, Long codeCli, Long codeEmp) {

		if(cp == null || codeCli == null|| codeEmp == null) 
			throw new RuntimeException("parametres invalides impossible de continuer ");
		Employe employe = em.find(Employe.class, codeEmp);
		Client client = em.find(Client.class, codeCli);
		cp.setClient(client);
		cp.setEmploye(employe);
		em.persist(cp);		
		return cp;
	}

	public Operation addOperation(Operation op, String codeCpte, Long codeEmp) {
		Compte cp = consulterCompte(codeCpte);
		Employe emp = getEmploye(codeEmp);
		op.setCompte(cp);
		op.setEmploye(emp);
		em.persist(op);
		return op;
	}

	public Compte consulterCompte(String codeC) {
		Compte cp = em.find(Compte.class, codeC);
		if(cp==null) throw new RuntimeException("Compte introuvable");
		return cp;
	}
	public Employe getEmploye(Long codeEmploye){
		Employe ep = em.find(Employe.class, codeEmploye);
		if(ep==null) throw new RuntimeException("Compte introuvable");
		return ep;
	}
	

	public List<Operation> consulterOperations(String codeCpte) {
		Query query =  em.createQuery("select o from Operation o where o.compte.codeCompte = :x");
		query.setParameter("x", codeCpte);
		return query.getResultList();
	}

	public Client consulterClient(Long codeCli) {
		Client c = em.find(Client.class,codeCli );
		if(c==null) throw new RuntimeException("client introuvable");
		return c;
	}

	public List<Client> consulterClients(String mc) {
		Query query =  em.createQuery("select o from Client o where o.nomClient like :x");
		query.setParameter("x", "%"+mc+"%");
		return query.getResultList();
	}

	public List<Compte> getComptesByClient(Long codeClient) {
		Query query =  em.createQuery("select o from Compte o where o.client.codeClient = :x");
		query.setParameter("x",codeClient);
		return query.getResultList();
	}

	public List<Compte> getComptesByEmploye(Long codeEmp) {
		Query query =  em.createQuery("select a from Compte a where a.employe.codeEmploye = :x");
		query.setParameter("x",codeEmp);
		return query.getResultList();
	}

	public List<Employe> ConsulterEmployes() {
		Query query =  em.createQuery("from Employe ");		
		return query.getResultList();
	}

	public List<Groupe> ConsulterGroupes() {
		Query query =  em.createQuery("from Groupe ");		
		return query.getResultList();	}

	public List<Employe> getEmployesByGroupe(Long codeGroupe) {
		Query query =  em.createQuery("select a from Employe a where a.groupe.codeGroupe = :x");
		query.setParameter("x",codeGroupe);
		return query.getResultList();	
	}

}
