package com.icc.decormoi.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import net.bytebuddy.implementation.auxiliary.AuxiliaryType.SignatureRelevant;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class Personne {
	
	
	//ATTRIBUT
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	protected Long id;	
	protected String nom ;
	protected String prenom ;
	protected String adresse;
	protected int tel;
	protected String email;
	private Date dinscription;
	
	
	//CONSTRUCTEUR
	public Personne() {
		super();
	}


	public Personne(Long id, String nom, String prenom, String adresse, int tel, String email, Date dinscription) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.dinscription = dinscription;
	}
	
	
	public Personne(String nom, String prenom, String adresse, int tel, String email, Date dinscription) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.dinscription = dinscription;
	}


	//GETTER ET SETTER
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
	
	


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Date getDinscription() {
		return dinscription;
	}



	public void setDinscription(Date dinscription) {
		this.dinscription = dinscription;
	}


	//TOSTRING
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", tel=" + tel + ", email="
				+ email + ", dinscription=" + dinscription + "]";
	}



	//TOSTRING
	
}
