package com.icc.decormoi.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.icc.decormoi.entities.Agent;
import com.icc.decormoi.entities.Article;
import com.icc.decormoi.entities.Categorie;
import com.icc.decormoi.entities.Client;
import com.icc.decormoi.entities.Commande;
import com.icc.decormoi.entities.Devis;
import com.icc.decormoi.entities.Devis.typeEvent;
import com.icc.decormoi.entities.Evenement;
import com.icc.decormoi.entities.Facture;
import com.icc.decormoi.entities.Fiche;
import com.icc.decormoi.entities.LigneCommande;
import com.icc.decormoi.entities.LigneFacture;
import com.icc.decormoi.entities.Mariage;
import com.icc.decormoi.entities.PanierC;
import com.icc.decormoi.entities.Role;

import com.icc.decormoi.entities.Utilisateur;
import com.icc.decormoi.entities.UtilisateursRoles;

public class DecorMoiDaoImpl implements IDecorMoiDAO {
	
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public Long ajouterCategorie(Categorie c) {
		
		em.persist(c);
		
		return c.getIdCategorie();
	}

	@Override
	public List<Categorie> listCategories() {
		Query req=em.createQuery("select c from Categorie c");
		return req.getResultList();
	}

	@Override
	public Categorie getCategorie(Long idCategorie) {
		
		return em.find(Categorie.class, idCategorie);
	}

	@Override
	public void supprimerCategorie(Long idCategorie) {
		
		Categorie c = em.find(Categorie.class, idCategorie);
		em.remove(c);
	}

	@Override
	public void modifierCategorie(Categorie c) {
		
		em.merge(c);
	}

	@Override
	public Long ajouterArticle(Article a, Long idCategorie) {
	
		Categorie c = getCategorie(idCategorie);
		a.setCategorie(c);
		em.persist(a);
		
		return a.getIdArticle();
	}

	@Override
	public List<Article> listarticles() {
		
		Query req=em.createQuery("select a from Article a");
		return req.getResultList();	
	}

	
	@Override
	public List<Article> articlesParMotCle(String mc) {
		
		Query req=em.createQuery("select a from Article a where a.designation like :x or a.description like :x");
		req.setParameter("x", "%" +mc+ "%");
		return req.getResultList();
	}

	
	@Override
	public List<Article> articlesParCategorie(Long idCategorie) {
		Query req=em.createQuery("select a from Article a where a.categorie.idCategorie = :x");
		req.setParameter("x", idCategorie);
		return req.getResultList();
	}

	
	@Override
	public List<Article> articlesSelectionnes() {
		
		Query req=em.createQuery("select a from Article a where a.selectionne=true");
		return req.getResultList();	
	}

	
	@Override
	public Article getArticle(Long idArticle) {
	
		return em.find(Article.class, idArticle);
	}

	
	@Override
	public void modifierArticle(Article a) {
		em.merge(a);	
	}

	
	@Override
	public void supprimerArticles(Long idArticle) {
		Article a = getArticle(idArticle);
		em.remove(a);
	}

	
	@Override
	public void ajouterUser(Utilisateur u) {
		
		em.persist(u);
	}

	
	@Override
	public void attribuerRole(Role r, Long id) {
		
		//Utilisateur u = em.find(Utilisateur.class,id);
		//u.getRoles().add(r);
		//em.persist(r);		
	}

	
	@Override
	public Commande enregistrerCommande(PanierC p, Client c) {
		
		em.persist(c);
		Commande com = new Commande();
		com.setDateCommande(new Date());
		com.setLigneCommandes(p.getItems());
		
		for(LigneCommande lc : p.getItems()) {
			em.persist(lc);
		}
		em.persist(com);
		return com;
	}

	@Override
	public void supprimerUser(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerRoleUser(Utilisateur u, Long role_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long ajouterEvent(Evenement e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifierEvent(Evenement e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerEvent(Long idEvenement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Evenement> listEvents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evenement getEvent(Long idEvenement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void affecterAgent(Long idEvenement, Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Evenement> EvenementAgent(Long idEvenement, Long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Long ajouterAgent(Agent a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifierAgent(Agent a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerAgent(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Agent> listAgents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long ajouterClient(Client c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifierClient(Client c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerClient(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Client> listClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long ajouterCommande(Evenement e, Commande c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifierCommande(Commande c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerCommande(Long idCommande) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Commande> listCommande() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean accepterCommande(Long idCommande) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Long ajouterDevis(Devis d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifierDevis(Devis d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerDevis(Long idEvenement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Devis> listDevis() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Devis getDevis(Long idEvenement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public typeEvent choisirTypeEvent(Devis d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> UtilisateurParMotCle(String mc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> UtilisateurParUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> findAllCommandesClients(Long numeroFiche) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> findAllCommandesClients(Long numeroFiche, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> findAllCommandesClients(Long numeroFiche, Boolean valide) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> findAllCommandesClients(Long numeroFiche, Date date, Boolean valide) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> findAllCommandesDuClient(Long numeroFiche, Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> findAllCommandesDuClient(Long numeroFiche, Date date, Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> findAllCommandesDuClient(Long numeroFiche, Boolean valide, Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> findAllCommandesDuClient(Long numeroFiche, Date date, Boolean valide, Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer NbreCommande(Long numeroFiche) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer NbreCommandeEntre(Date d1, Date d2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> ClientParMotCle(String mc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> ClientParId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Facture FactureClient(Long facture_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Facture> RechercherFacturesClients(Long numeroFiche) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Facture> RechercherFacturesClients(Long numeroFiche, Date facture_date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Facture> RechercherFacturesClients(Long numeroFiche, Long idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Facture> RechercherFacturesClients(Long numeroFiche, Date facture_date, Long idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer NbrFacture(Long numeroFiche) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer NbrAchatsArticle(Long numeroFiche) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer PrixAchatsArticle(Long numeroFiche) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer CalculeVente(Long numeroFiche, Date facture_date, Date facture_date2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer CalculePrixVente(Long numeroFiche, Date facture_date, Date facture_date2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer CalculeVenteArticle(Long numeroFiche, Date facture_date, Date facture_date2, Long idArticle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer CalculePrixVenteArticle(Long numeroFiche, Date facture_date, Date facture_date2, Long idArticle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> CalculeArticleVendu(Long numeroFiche, Date facture_date, Date facture_date2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fiche> rechercheFicheParNom(String nomFiche) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fiche> rechercheFicheParDateCreation(String nomFiche, Date dateCreation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fiche> rechercheFicheParDateFermeture(String nomFiche, Date dateFermeture) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fiche> rechercheFicheParDateCreationFermeture(String nomFiche, Date dateFermeture, Date dateCreation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fiche> rechercheFicheCloturer(String nomFiche) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fiche> rechercheFicheNonCloturer(String nomFiche) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LigneCommande rechercheLcParArticle(Long idCommande, String idArticle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LigneFacture rechercheLfParDate(Date facture_date, Date facture_date2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role rechercherRole(String role_nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role rechercherRoleParId(Long role_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role rechercherRoleParIdEtNom(Long role_id, String role_nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UtilisateursRoles rechercheRoleEtUser(String role_nom, String username) {
		// TODO Auto-generated method stub
		return null;
	}


}
