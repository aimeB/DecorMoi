package com.icc.decormoi.metier;

import java.util.List;

import com.icc.decormoi.domaine.Client;
import com.icc.decormoi.domaine.Commande;
import com.icc.decormoi.domaine.Facture;
import com.icc.decormoi.domaine.LigneCommande;
import com.icc.decormoi.domaine.Salle;


public interface IClientMetier extends IInternauteMetier {
	

	//Gestion des commandes
	public List<Commande> listCommande(Long id);

	//Gestion des Clients
	public void modifierClient (Client c);

	//Gestion des factures
	public Facture FactureClient(Long facture_id);
	public Facture PayerFacture (Long facture_id);

	//Gestion des lignes de commandes
	public LigneCommande rechercheLcParArticle( Long idCommande,String idArticle );
	
	//Gestion des Salle
	public List<Salle> listSalle();

}
