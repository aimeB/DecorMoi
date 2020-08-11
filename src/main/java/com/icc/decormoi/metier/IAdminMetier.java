package com.icc.decormoi.metier;

import java.util.Date;
import java.util.List;

import com.icc.decormoi.entities.Agent;
import com.icc.decormoi.entities.Article;
import com.icc.decormoi.entities.Categorie;
import com.icc.decormoi.entities.Client;
import com.icc.decormoi.entities.Commande;
import com.icc.decormoi.entities.Devis;
import com.icc.decormoi.entities.Dote;
import com.icc.decormoi.entities.Evenement;
import com.icc.decormoi.entities.Facture;
import com.icc.decormoi.entities.Fiancaille;
import com.icc.decormoi.entities.Fiche;
import com.icc.decormoi.entities.GardenParty;
import com.icc.decormoi.entities.LigneCommande;
import com.icc.decormoi.entities.LigneFacture;
import com.icc.decormoi.entities.Mariage;
import com.icc.decormoi.entities.PanierC;
import com.icc.decormoi.entities.PreciousTimes;
import com.icc.decormoi.entities.Role;
import com.icc.decormoi.entities.Salle;
import com.icc.decormoi.entities.Utilisateur;
import com.icc.decormoi.entities.UtilisateursRoles;
import com.icc.decormoi.entities.Devis.typeEvent;

public interface IAdminMetier extends IAgentMetier {
	
	//Gestion des Catégories
		public Long ajouterCategorie(Categorie c);
		public void supprimerCategorie(Long idCategorie);
		public void modifierCategorie(Categorie c);
		
		//Gestion des Articles
		public Long ajouterArticle(Article a, Long idCategorie);
		public void modifierArticle (Article a);
		public void supprimerArticles(Long idArticle);
		
		//Gestion des utilisateurs
		public void ajouterUser(Utilisateur u);
		public void supprimerUser(String username);
		public void attribuerRole(Role r, Long id);
		public void supprimerRoleUser(Utilisateur u, Long role_id);
		public List<Utilisateur> UtilisateurParMotCle(String mc);
		public List<Utilisateur> UtilisateurParUsername(String username);
		
		//Gestion des événements
		public Long ajouterEvent(Evenement e);
		public void modifierEvent (Evenement e);
		public void supprimerEvent(Long idEvenement);
		public List<Evenement> listEvents();
		public List<Evenement> listEvents(Long id);
		public Evenement getEvent(Long idEvenement);
		public void affecterAgent(Long idEvenement, Long id);

		//Gestion des commandes
		public Long ajouterCommande( Commande c);
		public void supprimerCommande(Long idCommande);
		public void modifierCommande(Commande c);
	
		public List<Commande> findAllCommandesClients(Long numeroFiche);
		public List<Commande> findAllCommandesClients(Long numeroFiche, Date date);
		public List<Commande> findAllCommandesClients(Long numeroFiche, Boolean valide);
		public List<Commande> findAllCommandesClients(Long numeroFiche, Date date, Boolean valide);
		
		
		public List<Commande> findAllCommandesDuClient(Long numeroFiche, Long Id);
		public List<Commande> findAllCommandesDuClient(Long numeroFiche, Date date, Long Id);
		public List<Commande> findAllCommandesDuClient(Long numeroFiche, Boolean valide,  Long Id);
		public List<Commande> findAllCommandesDuClient(Long numeroFiche, Date date, Boolean valide,  Long Id);
		
		
		public Commande enregistrerCommande(PanierC p, Client c);
		public boolean accepterCommande(Long idCommande);
		
		public Integer NbreCommande(Long numeroFiche);
		
		public Integer NbreCommandeEntre(Date d1,Date d2);
		
		
		//Gestion des Agents
		public Long ajouterAgent(Agent a);
		public List<Agent> listAgents();
		public void supprimerAgent(Long id);

		
		//Gestion des Clients
		public Long ajouterClient(Client c);
		public List<Client> listClients();
		public List<Client> ClientParMotCle(String mc);
		public List<Client> ClientParId(Long id);
		public void supprimerClient(Long id);
		
		//Gestion des Devis
		public Long ajouterDevis(Devis d);
		public void modifierDevis (Devis d);
		public void supprimerDevis(Long idEvenement);
		public List<Devis> listDevis();
		public Devis getDevis(Long idEvenement);
		public typeEvent choisirTypeEvent (Devis d);
		
		
		//Gestion des factures
		
		public Facture FactureClient(Long facture_id);
		
		public Facture PayerFacture (Long facture_id);
		
		public List<Facture> RechercherFacturesDuClient(Long id);

		public List<Facture> RechercherFacturesClients(Long numeroFiche);
		
		public List<Facture> RechercherFacturesClients(Long numeroFiche, Date facture_date);
		
		public List<Facture> RechercherFacturesClients(Long numeroFiche, Long idClient);
	 
		public List<Facture> RechercherFacturesClients(Long numeroFiche, Date facture_date, Long idClient);

		public Integer NbrFacture(Long numeroFiche);
		
		public Integer NbrAchatsArticle(Long numeroFiche);
		
		public Integer PrixAchatsArticle(Long numeroFiche);
		
		// Statititique Facture
		
		public Integer CalculeVente(Long numeroFiche, 
				Date facture_date, Date facture_date2);
		
		public Integer CalculePrixVente(Long numeroFiche, 
				Date facture_date, Date facture_date2);
		
		public Integer CalculeVenteArticle(Long numeroFiche, 
				Date facture_date, Date facture_date2, Long idArticle);
		
		public Integer CalculePrixVenteArticle(Long numeroFiche, 
				Date facture_date, Date facture_date2, Long idArticle);
		
		public List<Object[]> CalculeArticleVendu(Long numeroFiche, 
				Date facture_date, Date facture_date2);
		
		
		
		//Gestion des fiches
		
		public List<Fiche> rechercheFicheParNom(String nomFiche);
		
		public List<Fiche> rechercheFicheParDateCreation(String nomFiche, Date dateCreation );
		
		public List<Fiche> rechercheFicheParDateFermeture(String nomFiche, Date dateFermeture );
		
		public List<Fiche> rechercheFicheParDateCreationFermeture(String nomFiche, Date dateFermeture, Date dateCreation  );

		public List<Fiche> rechercheFicheCloturer(String nomFiche);

		public List<Fiche> rechercheFicheNonCloturer(String nomFiche);

		//Gestion des lignes de commandes
		
		public LigneCommande rechercheLcParArticle(Long idCommande, String idArticle);
		
		//Gestion des lignes de factures

		public LigneFacture rechercheLfParDate( Date facture_date, Date facture_date2 );

		
		//Gestion des roles
		
		public Role rechercherRole(String role_nom);

		public Role rechercherRoleParId(Long role_id);
		
		public Role rechercherRoleParIdEtNom(Long role_id, String role_nom);
		
		
		//Gestion des UtilisateurRoles
		
		public UtilisateursRoles rechercheRoleEtUser(String role_nom, String username);
		
		//Gestion des Mariages
		public Long ajouterMariage(Mariage m);
		public List<Mariage> listMariage();
		public void modifierMariage (Mariage m);
		public void supprimerMariage(Long idEvenement);
		
		//Gestion des Dotes
		public Long ajouterDote(Dote d);
		public List<Dote> listDote();
		public void modifierDote (Dote d);
		public void supprimerDote(Long idEvenement);
		
		//Gestion des Fiancaille
		public Long ajouterFiancaille(Fiancaille f);
		public List<Fiancaille> listFiancaille();
		public void modifierFiancaille (Fiancaille f);
		public void supprimerFiancaille(Long idEvenement);
		
		//Gestion des Garden Party
		public Long ajouterGardenParty(GardenParty gp);
		public List<GardenParty> listGardenParty();
		public void modifierGardenParty (GardenParty gp);
		public void supprimerGardenParty(Long idEvenement);
		
		//Gestion des Precious Times
		public Long ajouterPreciousTimes(PreciousTimes pt);
		public List<PreciousTimes> listPreciousTimes();
		public void modifierPreciousTimes (PreciousTimes pt);
		public void supprimerPreciousTimes(Long idEvenement);
		
		//Gestion des Salle
		public Long ajouterSalle(Salle s);
		public List<Salle> listSalle();
		public void modifierSalle (Salle s);
		public void supprimerSalle(Long idSalle);
		
		

}
