package com.icc.decormoi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class Personne {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	protected Long id;
	protected String nom ;
	protected String prenom ;
	protected String adresse;
	protected int tel;
	protected String email;
	protected int NumCompte;
	
	public Personne() {
		super();
	}

	public Personne(Long id, String nom, String prenom, String adresse, int tel, String email, int numCompte) {
		super();
		this.id = id;
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

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", tel=" + tel
				+ ", email=" + email + ", NumCompte=" + NumCompte + "]";
	}
	
	


}
