package com.icc.decormoi.entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Agent")
public class Agent extends Personne implements Serializable{
	
	
	//ATTRIBUTS
	private Date entreService;
	
	private boolean dispo;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	private Collection<Evenement> events;
	

	
	
	//CONSTRUCTEUR
	public Agent() {
		super();
		
	}

	public Agent(Date entreService, boolean dispo, Collection<Evenement> events) {
		super();
		this.entreService = entreService;
		this.dispo = dispo;
		this.events = events;
	}

	public Agent(Date entreService, boolean dispo) {
		super();
		this.entreService = entreService;
		this.dispo = dispo;
	}
	
	
	
	//GETTER ET SETTER
	public Date getEntreService() {
		return entreService;
	}
	public void setEntreService(Date entreService) {
		this.entreService = entreService;
	}
	
	
	public boolean isDispo() {
		return dispo;
	}
	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}
	
	
	public Collection<Evenement> getEvents() {
		return events;
	}
	public void setEvents(ArrayList<Evenement> events) {
		this.events = events;
	}


	
	//TOSTRING
	@Override
	public String toString() {
		return "Agent [idAgent=" + ", entreService=" + entreService + ", dispo=" + dispo + ", events="
				+ events + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", tel=" + tel + ", email="
				+ email + ", NumCompte=" + "]";
	}
	
	

}
