package com.icc.decormoi.entities;

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
public class Client extends Personne{
	
	private Date dinscription;
	
	@OneToMany(mappedBy="client")
	private Collection<Evenement> events;
	
	public Client() {
		super();
	}

	public Client(Date dinscription, Collection<Evenement> events) {
		super();
		this.dinscription = dinscription;
		this.events = events;
		
	}



	public Client(Date dinscription) {
		super();
		this.dinscription = dinscription;
	}

	public Date getDinscription() {
		return dinscription;
	}

	public void setDinscription(Date dinscription) {
		this.dinscription = dinscription;
	}

	public Collection<Evenement> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Evenement> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Client [dinscription=" + dinscription + ", events=" + events + ", devis=" + ", id=" + id
				+ ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", tel=" + tel + ", email=" + email
				+ ", NumCompte=" + "]";
	}

}
