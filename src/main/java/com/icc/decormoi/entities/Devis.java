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
	protected String nom ;
	protected String prenom ;
	protected int tel;
	protected String email;
	protected String Lieu;
	private Date dateEvent;
	private int nbPersonnes;
	private String Remarques;
	
	public Devis() {
		super();
	}

	public Devis(Long numDevis, String nom, String prenom, int tel, String email, String lieu, Date dateEvent,
			int nbPersonnes, String remarques) {
		super();
		this.numDevis = numDevis;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
		Lieu = lieu;
		this.dateEvent = dateEvent;
		this.nbPersonnes = nbPersonnes;
		Remarques = remarques;
	}

	public Long getNumDevis() {
		return numDevis;
	}

	public void setNumDevis(Long numDevis) {
		this.numDevis = numDevis;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLieu() {
		return Lieu;
	}

	public void setLieu(String lieu) {
		Lieu = lieu;
	}

	public Date getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}

	public int getNbPersonnes() {
		return nbPersonnes;
	}

	public void setNbPersonnes(int nbPersonnes) {
		this.nbPersonnes = nbPersonnes;
	}

	public String getRemarques() {
		return Remarques;
	}

	public void setRemarques(String remarques) {
		Remarques = remarques;
	}

	@Override
	public String toString() {
		return "Devis [numDevis=" + numDevis + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", email="
				+ email + ", Lieu=" + Lieu + ", dateEvent=" + dateEvent + ", nbPersonnes=" + nbPersonnes
				+ ", Remarques=" + Remarques + "]";
	}

	
	
	
}
