package com.icc.decormoi.domaine;

	import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
	import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	@Entity @Table( name = "T_Event")
	@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
	@DiscriminatorColumn(name="TYPE_EVENT", length= 4)
	public abstract class Event {
		
		
		//ATTRIBUTS
		@Id 
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(unique = true)
		protected Long id;
		
		protected static enum typeEvent{MARIAGE, FIANCAILLE, DOT, GARDENPARTY, PRECIOUSTIMES};
		
		@NonNull
		protected String NomEvent;
		
		@NonNull
		protected Date dateEvent;
		
		@NonNull
		protected int nbPersonnes;
		
		@NonNull
		protected String Remarques;
		
		protected final int prix = 0;
		
		
		
		
		
		
		@ManyToOne
		@JoinColumn(name="idClient")
		protected Client client;
		
		@ManyToOne
		@JoinColumn(name="idSalle")
		protected Salle salle;
		
		
		
		@OneToOne
		@JoinColumn(name = "facture_id")
		private Facture fact;
		
		@OneToOne
		@JoinColumn(name = "idCommande", nullable = false)
		private Commande commande;
}
