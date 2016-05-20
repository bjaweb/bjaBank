package com.bja.bapps.bjaBank.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte{

	private double taux;

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteEpargne(String codeCompte, double solde, double taux) {
		super(codeCompte,  solde);
		this.taux = taux;
	}

	

	
	
	
}
