package com.icc.decormoi.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "PreciousTimes")
public class PreciousTimes extends Evenement implements Serializable {
	
	
	private final int prixParPersonne =25;
	private final int montantMin = 120;
	private final int coutFixe= nbPersonnes * prixParPersonne;
	private int coutFixePrecious;

	

	public PreciousTimes() {
		super();
		
		if(coutFixe<montantMin) {
			
			this.coutFixePrecious = montantMin;
			
		}else {
			this.coutFixePrecious= coutFixe;
		}
	}




	public PreciousTimes(String nomEvent, Date dateEvent, int nbPersonnes, String remarques, Client client, Salle salle,
			Collection<Agent> agents, Facture fact) {
	
		super(nomEvent, dateEvent, nbPersonnes, remarques, client, salle, agents, fact);
		this.coutFixePrecious = 0;

		if(coutFixe<montantMin) {
			
			this.coutFixePrecious = montantMin;
			
		}else {
			this.coutFixePrecious= coutFixe;
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


	public int getCoutFixePrecious() {
		return coutFixePrecious;
	}


	@Override
	public String toString() {
		return "PreciousTimes [prixParPersonne=" + prixParPersonne + ", montantMin=" + montantMin + ", coutFixe="
				+ coutFixe + ", coutFixePrecious=" + coutFixePrecious + ", idEvenement=" + idEvenement + ", dateEvent="
				+ dateEvent + ", nbPersonnes=" + nbPersonnes + ", Remarques=" + Remarques + ", prix=" + prix
				+ ", client=" + client + ", salle=" + salle + ", ligneCommandes=" +", agents="
				+ agents + "]";
	}

	
	
	
}
