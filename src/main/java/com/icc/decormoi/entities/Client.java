package com.icc.decormoi.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client extends Personne{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idClient;
	
	private Date dinscription;
	
	@OneToMany(mappedBy="client")
	private Collection<Evenement> events;
	
	@OneToMany(mappedBy="client")
	private Collection<Devis> devis;
	
	public Client() {
		super();
	}
	
	public Client(String nom, String prénom, String adresse, int tel, String email, int numCompte) {
		super(nom, prénom, adresse, tel, email, numCompte);
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

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	@Override
	public String toString() {
		return "Client [dinscription=" + dinscription + ", nom=" + nom + ", prénom=" + prenom + ", tel=" + tel
				+ ", email=" + email + "]";
	}
	
}
