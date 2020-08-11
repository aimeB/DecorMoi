package com.icc.decormoi.metier;

import java.util.List;

import com.icc.decormoi.entities.Agent;
import com.icc.decormoi.entities.Evenement;

public interface IAgentMetier extends IClientMetier {
	
	//Gestion des Agents
	public void modifierAgent (Agent a);
	
	
	//Gestion des événements
	public List<Evenement> EvenementAgent(Long idEvenement, Long id);
}
