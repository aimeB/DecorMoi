package com.icc.decormoi.entities;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Admin")
public class Admin extends Personne implements Serializable {

	
	
	//CONSTRUCTEUR
	public Admin() {
		super();

	}

	
	
	//METHODES
	public void gererDevis() {
		
	}
	
	public void accepterEvenement() {
		
	}
	
	public void gererStock() {
		
	}
	
	public void gererGalerie() {
		
	}
	
	public void gererAgent() {
		
	}
	
	public void gererEvenement() {
		
	}
	
	public void gererDroitAcces() {
		
	}
	
	public void backUp() {
		
	}

	
	
	
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", tel=" + tel
				+ ", email=" + email + "]";
	}


	
	

}
