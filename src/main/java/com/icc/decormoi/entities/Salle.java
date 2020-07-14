package com.icc.decormoi.entities;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Salle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSalle;
	private String désignation;
	private boolean dispo;
	
	
	public Salle() {
		super();
		
	}


	public Salle(String désignation, boolean dispo) {
		super();
		this.désignation = désignation;
		this.dispo = dispo;
	}


	public String getDésignation() {
		return désignation;
	}


	public void setDésignation(String désignation) {
		this.désignation = désignation;
	}


	public boolean isDispo() {
		return dispo;
	}


	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}

	public int getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}


}
