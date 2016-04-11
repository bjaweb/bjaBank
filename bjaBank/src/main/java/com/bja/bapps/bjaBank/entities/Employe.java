package com.bja.bapps.bjaBank.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

// à faire classe personne au dessus
@Entity
public class Employe implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeEmploye;
	private String nomEmploye;
	private String prenomEmploye;
	private Date dateDEntree;
	
	// le superieur hierarchique
	@ManyToOne
	@JoinColumn(name="CODE_EMP_SUP")
	private Employe employeSup;
	
	@ManyToMany
	@JoinTable(name="EMP_GR")  // la table de relation sera EMP_GR, automatiquement les cles Primaire seront id_group et id_empl
/*	@JoinTable(name="EMP_GR", 
					joinColumns=@JoinColumn(name="CODE_EMP"),
					inverseJoinColumns= @JoinColumn(name="CODE_GR")
			   )  //dans le cas ou on veut donner des noms aux cles etrangeres */
	private Collection<Groupe> groupes;

	
	
	
	
	
	public Employe(String nomEmploye, String prenomEmploye, Date dateDEntree) {
		super();
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		this.dateDEntree = dateDEntree;
	}

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCodeEmploye() {
		return codeEmploye;
	}

	public void setCodeEmploye(Long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public String getPrenomEmploye() {
		return prenomEmploye;
	}

	public void setPrenomEmploye(String prenomEmploye) {
		this.prenomEmploye = prenomEmploye;
	}

	public Date getDateDEntree() {
		return dateDEntree;
	}

	public void setDateDEntree(Date dateDEntree) {
		this.dateDEntree = dateDEntree;
	}

	public Employe getEmployeSup() {
		return employeSup;
	}

	public void setEmployeSup(Employe employeSup) {
		this.employeSup = employeSup;
	}

	public Collection<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
	
	
	
	
}
