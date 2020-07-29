package com.icc.decormoi.dao;

import java.util.Date;
import java.util.List;

import com.icc.decormoi.entities.*;
import com.icc.decormoi.entities.Devis.typeEvent;

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
	public void ajouterUser(Utilisateur u);
	public void supprimerUser(Long id);
	public void attribuerRole(Role r, Long id);
	public void supprimerRoleUser(Utilisateur u, Long role_id);
	public List<Utilisateur> UtilisateurParMotCle(String mc);
	public List<Utilisateur> UtilisateurParUsername(String username);
	
	//Gestion des événements
	public Long ajouterEvent(Evenement e);
	public void modifierEvent (Evenement e);
	public void supprimerEvent(Long idEvenement);
	public List<Evenement> listEvents();
	public Evenement getEvent(Long idEvenement);
	public void affecterAgent(Long idEvenement, Long id);
	public List<Evenement> EvenementAgent(Long idEvenement, Long id);

	//Gestion des commandes
	public Long ajouterCommande(Evenement e, Commande c);
	public void modifierCommande (Commande c);
	public void supprimerCommande(Long idCommande);
	public List<Commande> listCommande();
	
	
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
	public void modifierAgent (Agent a);
	public void supprimerAgent(Long id);
	public List<Agent> listAgents();
	
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
	public typeEvent choisirTypeEvent (Devis d);
	
	
	//Gestion des factures
	
	public Facture FactureClient(Long facture_id);
 
	
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
	
	public LigneCommande rechercheLcParArticle( Long idCommande,String idArticle );
	
	//Gestion des lignes de factures

	public LigneFacture rechercheLfParDate( Date facture_date, Date facture_date2 );

	
	//Gestion des roles
	
	public Role rechercherRole(String role_nom);

	public Role rechercherRoleParId(Long role_id);
	
	public Role rechercherRoleParIdEtNom(Long role_id, String role_nom);
	
	
	//Gestion des UtilisateurRoles
	
	public UtilisateursRoles rechercheRoleEtUser(String role_nom, String username);
	
	
	
}
