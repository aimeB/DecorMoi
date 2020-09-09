package com.icc.decormoi.metier;

import java.util.List;

import com.icc.decormoi.domaine.Agent;
import com.icc.decormoi.domaine.Event;

public interface IAgentMetier extends IClientMetier {
	
	//Gestion des Agents
	public void modifierAgent (Agent a);
	
	
	//Gestion des événements
	public List<Event> EvenementAgent(Long idEvenement, Long id);
}
