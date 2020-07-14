package com.icc.decormoi.entities;


import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


public abstract class Personne {
	
	protected String nom ;
	protected String prenom ;
	protected String adresse;
	protected int tel;
	protected String email;
	protected int NumCompte;
	
	public Personne() {
		super();
	}

	public Personne(String nom, String prenom, String adresse, int tel, String email, int numCompte) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		NumCompte = numCompte;
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


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getNumCompte() {
		return NumCompte;
	}

	public void setNumCompte(int numCompte) {
		NumCompte = numCompte;
	}
	
}
