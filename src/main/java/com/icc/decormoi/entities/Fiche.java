package com.icc.decormoi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

@Entity 
public class Fiche  implements Serializable
{
	
	//ATTRIBUTS
	@Id  @GeneratedValue
	private Long numeroFiche;
	
	private String nomFiche;
 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateCreation;
	 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Nullable
	private Date dateFermeture;
	
	@ManyToOne
	@JoinColumn(name="username") 
	@NotFound(action = NotFoundAction.IGNORE)
	private Utilisateur utilisateur;
	
	
	//CONSTRUCTEURS
	public Fiche() { }

	public Fiche(String nom, Date dateCreation) {
		super();
		this.nomFiche = nom;
		this.dateCreation = dateCreation;
	}
	

	//GETTRE ET SETTER
	public Long getNumero() {
		return numeroFiche;
	}

	public void setNumero(Long numero) {
		this.numeroFiche = numero;
	}

	public String getNom() {
		return nomFiche;
	}

	public void setNom(String nom) {
		this.nomFiche = nom;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

  
	public Utilisateur getUser() {
		return utilisateur;
	}

	public void setUser(Utilisateur user) {
		this.utilisateur = user;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateFermeture() {
		return dateFermeture;
	}
 
	public void setDateFermeture(Date dateFermeture) {
		this.dateFermeture = dateFermeture;
	}
	
	
	//TOSTRING
	
	@Override
	public String toString() { 
		return "{"+numeroFiche+", "+nomFiche+", "+dateCreation+", "+dateFermeture+"}";
	}
	
}