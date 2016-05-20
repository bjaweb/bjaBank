package com.bja.bapps.bjaBank.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) //tous les comptes sur une seule table differencier par type
@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType=DiscriminatorType.STRING,length=2)
@Table(name="COMPTES")
public class Compte implements Serializable{
	
	@Id
//	@Column(name="")
	private String codeCompte;
	private Date dateCreation;
	private double solde;
	
	private String codeBanque;
	private String codeAgence;
	private String IBan;
	private String bic;
	
	// appartient à un client : vrai clé etrangere , colonne join client // on l'appelle comme on veut
	@ManyToOne
	@JoinColumn(name="CODE_CLI")
	private Client client;
	
	// est cree par un employe
	@ManyToOne
	@JoinColumn(name="CODE_EMP")
	private Employe employe;
	
	@OneToMany(mappedBy="compte")
	private Collection<Operation> operations;

	public String getCodeCompte() {
		return codeCompte;
	}

	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getCodeBanque() {
		return codeBanque;
	}

	public void setCodeBanque(String codeBanque) {
		this.codeBanque = codeBanque;
	}

	public String getCodeAgence() {
		return codeAgence;
	}

	public void setCodeAgence(String codeAgence) {
		this.codeAgence = codeAgence;
	}

	public String getIBan() {
		return IBan;
	}

	public void setIBan(String iBan) {
		IBan = iBan;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Collection<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public Compte(String codeCompte, Date dateCreation, double solde) {
//		super();
//		this.codeCompte = codeCompte;
//		this.dateCreation = dateCreation;
//		this.solde = solde;
//	}
//	
	
	public Compte(String codeCompte,  double solde) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = new Date();
		this.solde = solde;
	}
	
	
}
