package com.icc.decormoi.dao;

import java.util.Date;
import java.util.List;

import com.icc.decormoi.domaine.*;


public interface IDecorMoiDAO {
	
	//Gestion des Catégories
	public Long ajouterCategorie(Categorie c);
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCategorie);
	public void supprimerCategorie(Long idCategorie);
	public void modifierCategorie(Categorie c);
	
	//Gestion des Articles
	public Long ajouterArticle(Article a, Long idCategorie);
	public List<Article> listarticles();
	public List<Article> articlesParMotCle(String mc);
	public List<Article> articlesParCategorie(Long idCategorie);
	public List<Article> articlesSelectionnes();
	public Article getArticle(Long idArticle);
	public void modifierArticle (Article a);
	public void supprimerArticles(Long idArticle);
	
	//Gestion des utilisateurs
	public void ajouterUser(User u);
	public void supprimerUser(String username);
	public void attribuerRole(Role r, Long id);
	public void supprimerRoleUser(User u, Long role_id);
	public List<User> UtilisateurParMotCle(String mc);
	public List<User> UtilisateurParUsername(String username);
	
	//Gestion des événements
	public Long ajouterEvent(Event e);
	public void modifierEvent (Event e);
	public void supprimerEvent(Long idEvenement);
	public List<Event> listEvents();
	public List<Event> listEvents(Long id);
	public Event getEvent(Long idEvenement);
	public void affecterAgent(Long idEvenement, Long id);
	public List<Event> EvenementAgent(Long idEvenement, Long id);

	//Gestion des commandes
	public Long ajouterCommande(Commande c);
	public void supprimerCommande(Long idCommande);
	public List<Commande> listCommande();
	public List<Commande> listCommande(Long id);
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
	public void modifierAgent (Agent a);
	public void supprimerAgent(Long id);
	
	
	//Gestion des Clients
	public Long ajouterClient(Client c);
	public void modifierClient (Client c);
	public void supprimerClient(Long id);
	public List<Client> listClients();
	public List<Client> ClientParMotCle(String mc);
	public List<Client> ClientParId(Long id);
	
	//Gestion des Devis
	public Long ajouterDevis(Devis d);
	public void modifierDevis (Devis d);
	public void supprimerDevis(Long idEvenement);
	public List<Devis> listDevis();
	public Devis getDevis(Long idEvenement);
	
	
	
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
	
	// Statistique Facture
	
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

	
	//Gestion des Salle
	public Long ajouterSalle(Salle s);
	public List<Salle> listSalle();
	public void modifierSalle (Salle s);
	public void supprimerSalle(Long idSalle);
	
	//Gestion des roles
	
	public Role rechercherRole(String role_nom);

	public Role rechercherRoleParId(Long role_id);
	
	public Role rechercherRoleParIdEtNom(Long role_id, String role_nom);
	
	
	//Gestion des UtilisateurRoles
	

	
	
	
	
	
	
	
	
	
	
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

	

	
	
}
