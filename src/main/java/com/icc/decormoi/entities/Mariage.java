package com.icc.decormoi.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Mariage")
public class Mariage extends Evenement implements Serializable {
	
	
	
	//ATTRIBUT
	protected final int prixParPersonne= 15;
	
	protected final int coutFixeMariage = nbPersonnes * prixParPersonne ;
	
	

	//CONSTRUCTEURS
	public Mariage() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public Mariage(String nomEvent, Date dateEvent, int nbPersonnes, String remarques, Client client, Salle salle,
			Collection<Agent> agents, Facture fact) {
		super(nomEvent, dateEvent, nbPersonnes, remarques, client, salle, agents, fact);
		// TODO Auto-generated constructor stub
	}




	//GETTER ET SETTER
	public int getPrixParPersonne() {
		return prixParPersonne;
	}


	public int getCoutFixeMariage() {
		return prix;
	}


	//TOSTRING
	@Override
	public String toString() {
		return "Mariage [prixParPersonne=" + prixParPersonne + ", coutFixeMariage=" + coutFixeMariage + ", idEvenement="
				+ idEvenement + ", dateEvent=" + dateEvent + ", nbPersonnes=" + nbPersonnes + ", Remarques=" + Remarques
				+ ", prix=" + prix + ", client=" + client + ", salle=" + salle + ", agents=" + agents + "]";
	}

}
