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
	public void supprimerUser(String username) {
		Utilisateur c = em.find(Utilisateur.class, username);
		em.remove(c);
		
	}

	@Override
	public void supprimerRoleUser(Utilisateur u, Long role_id) {
		Utilisateur c = em.find(Utilisateur.class, role_id);
		em.remove(c);
	}

	@Override
	public Long ajouterEvent(Evenement e) {
	em.persist(e);
		return null;
	}

	@Override
	public void modifierEvent(Evenement e) {
		em.merge(e);
		
	}

	@Override
	public void supprimerEvent(Long idEvenement) {
		Evenement e = em.find(Evenement.class, idEvenement);
		em.remove(e);
		
	}

	@Override
	public List<Evenement> listEvents() {
		Query req=em.createQuery("select e from Evenement e");
		return req.getResultList();		
	}

	@Override
	public Evenement getEvent(Long idEvenement) {
		
		return  em.find(Evenement.class, idEvenement);
	}

	//A FAIRE
	@Override
	public void affecterAgent(Long idEvenement, Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
	// A VERIFIER
	@Override
	public List<Evenement> EvenementAgent(Long idEvenement, Long id) {
		Query req=em.createQuery("select e from Evenement e where e.agents.id= :x");
		req.setParameter("x", id);
		return req.getResultList();
		
	}

	@Override
	public Long ajouterAgent(Agent ag) {
		em.persist(ag);
		return null;
	}

	@Override
	public void modifierAgent(Agent ag) {
		em.merge(ag);
		
	}

	@Override
	public void supprimerAgent(Long id) {
		Agent ag = em.find(Agent.class, id);
		em.remove(ag);
		
	}

	@Override
	public List<Agent> listAgents() {
		Query req=em.createQuery("select ag from Agent ag");
		return req.getResultList();
	}

	@Override
	public Long ajouterClient(Client c) {
		em.persist(c);
		return null;
	}

	@Override
	public void modifierClient(Client c) {
		em.merge(c);
		
	}

	@Override
	public void supprimerClient(Long id) {
		Client c = em.find(Client.class, id);
		em.remove(c);
		
	}

	@Override
	public List<Client> listClients() {
		Query req=em.createQuery("select c from Client c");
		return req.getResultList();
	}

	//A VERIFIER
	@Override
	public Long ajouterCommande(Commande com) {
		em.persist(com);
		return null;
	}

	@Override
	public void modifierCommande(Commande com) {
		em.merge(com);
		
	}

	@Override
	public void supprimerCommande(Long idCommande) {
		Commande com = em.find(Commande.class, idCommande);
		em.remove(com);
		
		
	}

	@Override
	public List<Commande> listCommande() {
		Query req=em.createQuery("select c from Commande c");
		return req.getResultList();
	}

	// A FAIRE
	@Override
	public boolean accepterCommande(Long idCommande) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Long ajouterDevis(Devis d) {
		em.persist(d);
		return null;
	}

	@Override
	public void modifierDevis(Devis d) {
		em.merge(d);
		
	}

	@Override
	public void supprimerDevis(Long idEvenement) {
		Devis Devis = em.find(Devis.class, idEvenement);
		em.remove(Devis);
		
		
	}

	@Override
	public List<Devis> listDevis() {
		Query req=em.createQuery("select d from Devis d");
		return req.getResultList();	
	}

	@Override
	public Devis getDevis(Long idEvenement) {
	
		return em.find(Devis.class, idEvenement);
	}

	//A FAIRE
	@Override
	public typeEvent choisirTypeEvent(Devis d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> UtilisateurParMotCle(String mc) {
		Query req=em.createQuery("select u from Utilisateur u where u.username like :x");
		req.setParameter("x", "%" +mc+ "%");
		return req.getResultList();
	}

	
	@Override
	public List<Utilisateur> UtilisateurParUsername(String username) {
		Query req=em.createQuery("select u from Utilisateur u where u.username = :x");
		req.setParameter("x", username);
		return req.getResultList();
	}
	
	@Override
	public List<Commande> findAllCommandesClients(Long numeroFiche) {
		Query req=em.createQuery("select c from Commande c where c.fiche = :x");
		req.setParameter("x", numeroFiche);
		return req.getResultList();
	}

	
	@Override
	public List<Commande> findAllCommandesClients(Long numeroFiche, Date date) {
		Query req=em.createQuery("select c from Commande c where c.fiche.numero=:num and c.dateCommande=:x");
		req.setParameter("num", numeroFiche);
		req.setParameter("x", date);
		return req.getResultList();
	}
	
	@Override
	public List<Commande> findAllCommandesClients(Long numeroFiche, Boolean valide) {
		Query req=em.createQuery("select c from Commande c where c.fiche.numero=:num and c.valide=:x");
		req.setParameter("num", numeroFiche);
		req.setParameter("x", valide);
		return req.getResultList();
	}

	@Override
	public List<Commande> findAllCommandesClients(Long numeroFiche, Date date, Boolean valide) {
		Query req=em.createQuery("select c from Commande c where c.fiche.numero=:num and c.valide=:v and c.dateCommande=:d");
		req.setParameter("num", numeroFiche);
		req.setParameter("v", valide);
		req.setParameter("d", date);
		return req.getResultList();
	}

	@Override
	public List<Commande> findAllCommandesDuClient(Long numeroFiche, Long Id) {
		Query req=em.createQuery("select c from Commande c where c.fiche.numero=:num and c.client=:c");
		req.setParameter("num", numeroFiche);
		req.setParameter("c", Id);
		return req.getResultList();
	}

	@Override
	public List<Commande> findAllCommandesDuClient(Long numeroFiche, Date date, Long Id) {
		Query req=em.createQuery("select c from Commande c where c.fiche.numero=:num and c.dateCommande=:d and c.client=:c");
		req.setParameter("num", numeroFiche);
		req.setParameter("d", date);
		req.setParameter("c", Id);
		return req.getResultList();
	}

	@Override
	public List<Commande> findAllCommandesDuClient(Long numeroFiche, Boolean valide, Long Id) {
		Query req=em.createQuery("select c from Commande c where c.fiche.numero=:num and c.valide=:v and c.client=:c");
		req.setParameter("num", numeroFiche);
		req.setParameter("v", valide);
		req.setParameter("c", Id);
		return req.getResultList();
	}

	@Override
	public List<Commande> findAllCommandesDuClient(Long numeroFiche, Date date, Boolean valide, Long Id) {
		Query req=em.createQuery("select c from Commande c where c.fiche.numero=:num and c.dateCommande=:d and c.valide=:v and c.client=:c");
		req.setParameter("num", numeroFiche);
		req.setParameter("d", date);
		req.setParameter("v", valide);
		req.setParameter("c", Id);
		return req.getResultList();
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

	@Override
	public List<Evenement> listEvents(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long ajouterMariage(Mariage m) {
		em.persist(m);
		return null;
	}

	@Override
	public List<Mariage> listMariage() {
		Query req=em.createQuery("select m from Mariage m");
		return req.getResultList();		
	}

	@Override
	public void modifierMariage(Mariage m) {
		em.merge(m);
		
	}

	@Override
	public void supprimerMariage(Long idEvenement) {
		Mariage mar = em.find(Mariage.class, idEvenement);
		em.remove(mar);
				
	}

	@Override
	public Long ajouterDote(Dote d) {
		em.persist(d);
		return null;
	}

	@Override
	public List<Dote> listDote() {
		Query req=em.createQuery("select d from Dote d");
		return req.getResultList();		
	}

	@Override
	public void modifierDote(Dote d) {
		em.merge(d);
		
	}

	@Override
	public void supprimerDote(Long idEvenement) {
		Dote dot = em.find(Dote.class, idEvenement);
		em.remove(dot);
				
	}

	@Override
	public Long ajouterFiancaille(Fiancaille f) {
		em.persist(f);
		return null;
	}

	@Override
	public List<Fiancaille> listFiancaille() {
		Query req=em.createQuery("select f from Fiancaille f");
		return req.getResultList();		
	}

	@Override
	public void modifierFiancaille(Fiancaille f) {
		em.merge(f);
		
	}

	@Override
	public void supprimerFiancaille(Long idEvenement) {
		Fiancaille fia = em.find(Fiancaille.class, idEvenement);
		em.remove(fia);
				
	}

	@Override
	public Long ajouterGardenParty(GardenParty gp) {
		em.persist(gp);
		return null;
	}

	@Override
	public List<GardenParty> listGardenParty() {
		Query req=em.createQuery("select gp from GardenParty gp");
		return req.getResultList();		
	}

	@Override
	public void modifierGardenParty(GardenParty gp) {
		em.merge(gp);
		
	}

	@Override
	public void supprimerGardenParty(Long idEvenement) {
		GardenParty gp = em.find(GardenParty.class, idEvenement);
		em.remove(gp);
				
	}

	@Override
	public Long ajouterPreciousTimes(PreciousTimes pt) {
		em.persist(pt);
		return null;
	}

	@Override
	public List<PreciousTimes> listPreciousTimes() {
		Query req=em.createQuery("select pt from PreciousTimes pt");
		return req.getResultList();	
	}

	@Override
	public void modifierPreciousTimes(PreciousTimes pt) {
		em.merge(pt);
		
	}

	@Override
	public void supprimerPreciousTimes(Long idEvenement) {
		PreciousTimes pt = em.find(PreciousTimes.class, idEvenement);
		em.remove(pt);
				
	}

	@Override
	public Long ajouterSalle(Salle s) {
		em.persist(s);
		return null;
	}

	@Override
	public List<Salle> listSalle() {
		Query req=em.createQuery("select s from Salle s");
		return req.getResultList();		
	}

	@Override
	public void modifierSalle(Salle s) {
		em.merge(s);
		
	}

	@Override
	public void supprimerSalle(Long idSalle) {
		Salle sal = em.find(Salle.class, idSalle);
		em.remove(sal);
				
	}

	@Override
	public List<Commande> listCommande(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Facture PayerFacture(Long facture_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Facture> RechercherFacturesDuClient(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
