package com.icc.decormoi.dto;


import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

import com.icc.decormoi.domaine.Client;
import com.icc.decormoi.domaine.Commande;
import com.icc.decormoi.domaine.Facture;
import com.icc.decormoi.domaine.Salle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventDTO {

	protected Long id;
	
	protected static enum typeEvent{MARIAGE, FIANCAILLE, DOT, GARDENPARTY, PRECIOUSTIMES};
	
	protected String NomEvent;
	
	protected Date dateEvent;
	
	protected int nbPersonnes;
	
	protected String Remarques;
	
	protected final int prix = 0;
	
	protected ClientDTO client;
	
	protected SalleDTO salle;
}

