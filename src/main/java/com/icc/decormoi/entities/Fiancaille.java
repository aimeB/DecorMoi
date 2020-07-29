package com.icc.decormoi.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "Fiancaille")
public class Fiancaille extends Mariage implements Serializable{

	public Fiancaille() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Fiancaille(String nomEvent, Date dateEvent, int nbPersonnes, String remarques, Client client, Salle salle,
			Collection<Agent> agents, Facture fact) {
		super(nomEvent, dateEvent, nbPersonnes, remarques, client, salle, agents, fact);
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Fiancaille [prixParPersonne=" + prixParPersonne + ", coutFixeFiancaille=" + coutFixeMariage
				+ ", idEvenement=" + idEvenement + ", dateEvent=" + dateEvent + ", nbPersonnes=" + nbPersonnes
				+ ", Remarques=" + Remarques + ", prix=" + prix + ", client=" + client + ", salle=" + salle
				+ ", ligneCommandes=" +  ", agents=" + agents + "]";
	}

	
	

}
