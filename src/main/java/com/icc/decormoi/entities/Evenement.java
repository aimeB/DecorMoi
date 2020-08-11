package com.icc.decormoi.entities;

	import java.io.Serializable;
import java.util.Collection;
	import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
	import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

	@Entity
	@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
	@DiscriminatorColumn(name="TYPE_EVENT", length= 4)
	public abstract class Evenement implements Serializable {
		
		
		//ATTRIBUTS
		@Id @GeneratedValue 
		protected Long idEvenement;
		
		protected String NomEvent;
		
		protected Date dateEvent;
		
		protected int nbPersonnes;
		
		protected String Remarques;
		
		protected final int prix = 0;
		
		@ManyToOne
		@JoinColumn(name="idClient")
		protected Client client;
		
		@ManyToOne
		@JoinColumn(name="idSalle")
		protected Salle salle;
		
		
		@ManyToMany(mappedBy = "events")
		protected Collection<Agent> agents;
		
		@OneToOne
		@JoinColumn(name = "facture_id")
		private Facture fact;
		
		
		
		
		
		//CONSTRUCTEURS
		public Evenement() {
			super();
			// TODO Auto-generated constructor stub
		}
		


		public Evenement(String nomEvent, Date dateEvent, int nbPersonnes, String remarques, Client client, Salle salle,
				Collection<Agent> agents, Facture fact) {
			super();
			NomEvent = nomEvent;
			this.dateEvent = dateEvent;
			this.nbPersonnes = nbPersonnes;
			Remarques = remarques;
			this.client = client;
			this.salle = salle;
			this.agents = agents;
			this.fact = fact;
		}






		//GETTER ET SETTER
		public Long getIdEvenement() {
			return idEvenement;
		}

		public void setIdEvenement(Long idEvenement) {
			this.idEvenement = idEvenement;
		}

		public Date getDateEvent() {
			return dateEvent;
		}

		public void setDateEvent(Date dateEvent) {
			this.dateEvent = dateEvent;
		}

		public int getNbPersonnes() {
			return nbPersonnes;
		}

		public void setNbPersonnes(int nbPersonnes) {
			this.nbPersonnes = nbPersonnes;
		}

		public String getRemarques() {
			return Remarques;
		}

		public void setRemarques(String remarques) {
			Remarques = remarques;
		}

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}

		public Salle getSalle() {
			return salle;
		}

		public void setSalle(Salle salle) {
			this.salle = salle;
		}

	
		public Collection<Agent> getAgents() {
			return agents;
		}

		public void setAgents(Collection<Agent> agents) {
			this.agents = agents;
		}

		public int getPrix() {
			return prix;
		}


		
		
		public String getNomEvent() {
			return NomEvent;
		}



		public void setNomEvent(String nomEvent) {
			NomEvent = nomEvent;
		}



		public Facture getFact() {
			return fact;
		}



		public void setFact(Facture fact) {
			this.fact = fact;
		}



		//TOSTRING
		@Override
		public String toString() {
			return "Evenement [idEvenement=" + idEvenement + ", dateEvent=" + dateEvent + ", nbPersonnes=" + nbPersonnes
					+ ", Remarques=" + Remarques + ", prix=" + prix + ", client=" + client + ", salle=" + salle
					+ ", agents=" + agents + "]";
		}


}
