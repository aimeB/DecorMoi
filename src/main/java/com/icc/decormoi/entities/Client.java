package com.icc.decormoi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Client")
public class Client extends Personne implements Serializable{
	
	
	//Constructeur
	public Client() {
		super();
	}
	

	public Client( String nom, String prenom, String adresse, int tel, String email, Date dinscription) {
		super( nom, prenom, adresse, tel, email, dinscription);
		// TODO Auto-generated constructor stub
	}
	

	//TOSTRING
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", tel=" + tel + ", email="
				+ email + "]";
	}


	
}
