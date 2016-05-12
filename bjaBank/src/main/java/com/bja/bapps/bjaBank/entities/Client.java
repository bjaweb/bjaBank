package com.bja.bapps.bjaBank.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="CLIENTS")
public class Client extends BaseEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODE_CLI")
	private Long codeClient	;
	
	private String nomClient;
	private String prenomClient;
	private String adresseClient;
	
	// le one to many n'est pas obligatoire car le client est dans le compte
	@OneToMany(mappedBy="client", fetch=FetchType.LAZY) //client ici est compte.client : par defaut tjs lazy (autre valeur posible eager)
	private Collection<Compte> comptes;
	
	
	public Long getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public String getAdresseClient() {
		return adresseClient;
	}
	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	public Client() {
		super();
	}
	public Client(String nomClient, String prenom, String adresseClient) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenom;
		this.adresseClient = adresseClient;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Client [codeClient=");
		builder.append(codeClient);
		builder.append(", nomClient=");
		builder.append(nomClient);
		builder.append(", prenomClient=");
		builder.append(prenomClient);
		builder.append(", adresseClient=");
		builder.append(adresseClient);
		try{
		builder.append(", comptes=");
		builder.append(comptes);
		}catch(Exception e){
			log.error("impossible de charger le compte ",e);
		}
		builder.append("]");
		return builder.toString();
	}
	
	

}
