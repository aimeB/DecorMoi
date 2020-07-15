package com.icc.decormoi.entities;


	
	import java.io.Serializable;
	import java.util.Collection;
	import java.util.Date;

	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.OneToMany;
	import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

	@Entity
	public class Evenement implements Serializable{
		
		@Id @GeneratedValue
		private Long idEvenement;
		private Date dateEvent;
		
		@ManyToOne
		@JoinColumn(name="idClient")
		private Client client;
		
		@ManyToOne
		@JoinColumn(name="idSalle")
		private Salle salle;
		
		@OneToMany
		@JoinColumn(name="idEvenement")
		private Collection<LigneCommande> ligneCommandes;
		
		@OneToMany
		@JoinColumn(name="idEvenement")
		private Collection<Agent> agents;

		public Evenement() {
			super();
			
		}
		public Evenement(Date dateEvent, Client client, Salle salle, Collection<Agent> agents) {
			super();
			this.dateEvent = dateEvent;
			this.client = client;
			this.salle = salle;
			this.agents = agents;
		}
		
		public Date getDateEvent() {
			return dateEvent;
		}

		public void setDateEvent(Date dateEvent) {
			this.dateEvent = dateEvent;
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

		public Collection<Agent> affecterAgent(Agent agent) {
			return agents;
		}

		public Collection<LigneCommande> getLigneCommandes() {
			return ligneCommandes;
		}

		public void setLigneCommandes(Collection<LigneCommande> ligneCommandes) {
			this.ligneCommandes = ligneCommandes;
		}
		public Long getIdEvenement() {
			return idEvenement;
		}
		public void setIdEvenement(Long idEvenement) {
			this.idEvenement = idEvenement;
		}
		public Client getClient() {
			return client;
		}
		public void setClient(Client client) {
			this.client = client;
		}
		@Override
		public String toString() {
			return "Evenement [idEvenement=" + idEvenement + ", dateEvent=" + dateEvent + ", client=" + client
					+ ", salle=" + salle + ", ligneCommandes=" + ligneCommandes + ", agents=" + agents + "]";
		}
		
		

}
