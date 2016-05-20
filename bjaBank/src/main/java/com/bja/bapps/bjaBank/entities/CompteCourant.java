package com.bja.bapps.bjaBank.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC") //si je cree un compte courant la colonne type sera CC
public class CompteCourant extends Compte{

	private double decouvert;

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public CompteCourant(String codeCompte, Date dateCreation, double solde, double decouvert) {
//		super(codeCompte, dateCreation, solde);
//		this.decouvert = decouvert;
//	}

	public CompteCourant(String codeCompte,  double solde, double decouvert) {
		super(codeCompte,  solde);
		this.decouvert = decouvert;
	}
	
	
}
