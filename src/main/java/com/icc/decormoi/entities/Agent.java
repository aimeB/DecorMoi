package com.icc.decormoi.entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Agent")
public class Agent extends Personne implements Serializable{
	
	
	private Date entreService;
	private boolean dispo;
	
	@OneToMany(mappedBy="client", fetch = FetchType.LAZY)
	private Collection<Evenement> events;

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


	@Override
	public String toString() {
		return "Agent [idAgent=" + ", entreService=" + entreService + ", dispo=" + dispo + ", events="
				+ events + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", tel=" + tel + ", email="
				+ email + ", NumCompte=" + NumCompte + "]";
	}
	
	

}
