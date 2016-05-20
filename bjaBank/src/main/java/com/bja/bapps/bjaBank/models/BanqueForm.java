package com.bja.bapps.bjaBank.models;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.bja.bapps.bjaBank.entities.Compte;

public class BanqueForm {
	
	@NotEmpty
	@Size(min=2, max=20)  // validation auto du form le code ne doit pas etre vide et doit faire entre 2 et 20 car
	private String code;
	private Compte compte;
	private String typeCompte;
	private String exception;
	
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public String getTypeCompte() {
		return typeCompte;
	}
	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}
	
	
}
