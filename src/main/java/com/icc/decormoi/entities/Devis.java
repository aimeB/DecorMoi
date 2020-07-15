package com.icc.decormoi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Devis implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "numDevis")
	private Long numDevis;
	private Date dateDevis;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	
	@OneToMany
	@JoinColumn(name="numDevis")
	private Collection<LigneCommande> ligneCommandes;
	
	public Devis() {
		super();
	}

	public Devis(Date dateDevis) {
		super();
		this.dateDevis = dateDevis;
		
	}

	public Long getNumDevis() {
		return numDevis;
	}

	public void setNumDevis(Long numDevis) {
		this.numDevis = numDevis;
	}

	public Date getDateDevis() {
		return dateDevis;
	}

	public void setDateDevis(Date dateDevis) {
		this.dateDevis = dateDevis;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(Collection<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	@Override
	public String toString() {
		return "Devis [numDevis=" + numDevis + ", dateDevis=" + dateDevis + ", client=" + client + ", ligneCommandes="
				+ ligneCommandes + "]";
	}
	
	
	
}
