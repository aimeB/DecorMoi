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

	public Admin() {
		super();

	}

	public void gererDevis() {
		
	}
	
	public void accepterCommande() {
		
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
		return "Admin [idAdmin=" + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", tel="
				+ tel + ", email=" + email + ", NumCompte=" + "]";
	}
	
	

}
