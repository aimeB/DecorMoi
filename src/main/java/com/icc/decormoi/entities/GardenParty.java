package com.icc.decormoi.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@DiscriminatorValue("GAPA")
public class GardenParty extends Evenement implements Serializable{
	
	private final int prixParPersonne =35;
	private final int montantMin = 350;
	private final int coutFixe= nbPersonnes * prixParPersonne;
	private int coutFixeGarden;

	

	public GardenParty() {
		super();
		
		if(coutFixe<montantMin) {
			
			this.coutFixeGarden = montantMin;
			
		}else {
			this.coutFixeGarden= coutFixe;
		}
	}


	public GardenParty(String nomEvent, Date dateEvent, int nbPersonnes, String remarques, Client client, Salle salle,
			Collection<Agent> agents, Facture fact) {
	
		super(nomEvent, dateEvent, nbPersonnes, remarques, client, salle, agents, fact);
		this.coutFixeGarden = 0;

		if(coutFixe<montantMin) {
			
			this.coutFixeGarden = montantMin;
			
		}else {
			this.coutFixeGarden= coutFixe;
		}
	}


	public int getPrixParPersonne() {
		return prixParPersonne;
	}


	public int getMontantMin() {
		return montantMin;
	}


	public int getCoutFixe() {
		return coutFixe;
	}


	public int getcoutFixeGarden() {
		return coutFixeGarden;
	}


	@Override
	public String toString() {
		return "GardenParty [prixParPersonne=" + prixParPersonne + ", montantMin=" + montantMin + ", coutFixe="
				+ coutFixe + ", coutFixePrecious=" + coutFixeGarden + ", idEvenement=" + idEvenement + ", dateEvent="
				+ dateEvent + ", nbPersonnes=" + nbPersonnes + ", Remarques=" + Remarques + ", prix=" + prix
				+ ", client=" + client + ", salle=" + salle + ", ligneCommandes=" + ", agents="
				+ agents + "]";
	}

	
	
	


}
