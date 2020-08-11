package com.icc.decormoi.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@DiscriminatorValue("DOTE")
public class Dote extends Mariage implements Serializable{
	

	public Dote() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Dote(String nomEvent, Date dateEvent, int nbPersonnes, String remarques, Client client, Salle salle,
			Collection<Agent> agents, Facture fact) {
		super(nomEvent, dateEvent, nbPersonnes, remarques, client, salle, agents, fact);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Fiancaille [prixParPersonne=" + prixParPersonne + ", coutFixeDote=" + coutFixeMariage
				+ ", idEvenement=" + idEvenement + ", dateEvent=" + dateEvent + ", nbPersonnes=" + nbPersonnes
				+ ", Remarques=" + Remarques + ", prix=" + prix + ", client=" + client + ", salle=" + salle
				+ ", ligneCommandes=" +", agents=" + agents + "]";
	}


}
