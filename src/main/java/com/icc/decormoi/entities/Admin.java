package com.icc.decormoi.entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Admin extends Personne implements Serializable {
	
	@Id @GeneratedValue
	private Long idAdmin;
	
	public Admin() {
		super();

	}

	public Admin(String nom, String prenom, String adresse, int tel, String email, int numCompte) {
		super(nom, prenom, adresse, tel, email, numCompte);
		// TODO Auto-generated constructor stub
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
		return "Admin [id=" + idAdmin + ", nom=" + nom + ", prénom=" + prenom + ", tel=" + tel + ", email=" + email + "]";
	}

	public Long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}

}
