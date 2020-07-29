package com.icc.decormoi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Devis extends Evenement implements Serializable {
	
	
	
	//ATTRIBUTS

	protected String nom ;
	protected String prenom ;
	protected int tel;
	protected String email;
	public enum typeEvent{MARIAGE,FIANCAILLE,DOTE, PRECIOUSTIMES, GARDENPARTY};
	protected String lieu;
	
	
	
	//CONSTRUCTEURS
	
	public Devis() {
		super();
		
	}
	
	
	public Devis(String nomEvent, Date dateEvent, int nbPersonnes, String remarques, Client client, Salle salle,
			Collection<Agent> agents, Facture fact) {
		super(nomEvent, dateEvent, nbPersonnes, remarques, client, salle, agents, fact);
		// TODO Auto-generated constructor stub
	}



	public Devis(String nom, String prenom, int tel, String email, String lieu) {
		super();
		
		for(typeEvent te : typeEvent.values()){
		      if(typeEvent.MARIAGE.equals(te))
		        new Mariage();
		      else if(typeEvent.FIANCAILLE.equals(te))
		    	  new Fiancaille();
		      else if(typeEvent.DOTE.equals(te))
		    	  new Dote();
		      else if(typeEvent.PRECIOUSTIMES.equals(te))
		    	  new PreciousTimes();
		      else if(typeEvent.GARDENPARTY.equals(te))
		    	  new GardenParty();
		}
		
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
		this.lieu = lieu;
	}
	
	
	//GETTER ET SETTER
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}


	@Override
	public String toString() {
		return "Devis [nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", email=" + email + ", lieu=" + lieu
				+ ", idEvenement=" + idEvenement + ", NomEvent=" + NomEvent + ", dateEvent=" + dateEvent
				+ ", nbPersonnes=" + nbPersonnes + ", Remarques=" + Remarques + ", prix=" + prix + ", client=" + client
				+ ", salle=" + salle + ", agents=" + agents + "]";
	}
	

	
	//TOSTRING
	
	
}