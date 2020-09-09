package com.icc.decormoi.metier;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.icc.decormoi.dao.IDecorMoiDAO;
import com.icc.decormoi.domaine.Agent;
import com.icc.decormoi.domaine.Article;
import com.icc.decormoi.domaine.Categorie;
import com.icc.decormoi.domaine.Client;
import com.icc.decormoi.domaine.Commande;
import com.icc.decormoi.domaine.Devis;
import com.icc.decormoi.domaine.Dote;
import com.icc.decormoi.domaine.Event;
import com.icc.decormoi.domaine.Facture;
import com.icc.decormoi.domaine.Fiancaille;
import com.icc.decormoi.domaine.Fiche;
import com.icc.decormoi.domaine.GardenParty;
import com.icc.decormoi.domaine.LigneCommande;
import com.icc.decormoi.domaine.LigneFacture;
import com.icc.decormoi.domaine.Mariage;
import com.icc.decormoi.domaine.PanierC;
import com.icc.decormoi.domaine.PreciousTimes;
import com.icc.decormoi.domaine.Role;
import com.icc.decormoi.domaine.Salle;
import com.icc.decormoi.domaine.User;
import com.icc.decormoi.domaine.User;



@Transactional
public class DecorMoiMetierImpl implements IAdminMetier {

	private IDecorMoiDAO dao;


	public void setDao(IDecorMoiDAO dao) {
		this.dao = dao;
	}

	@Override
	public void modifierAgent(Agent a) {

		dao.modifierAgent(a);
	}

	@Override
	public void supprimerAgent(Long id) {

		dao.supprimerAgent(id);
	}

	@Override
	public List<Event> EvenementAgent(Long idEvenement, Long id) {
	
		return dao.EvenementAgent(idEvenement, id);
	}

	@Override
	public void modifierCommande(Commande c) {
		dao.modifierCommande(c);		
	}

	@Override
	public List<Commande> listCommande(Long id) {
	
		return dao.listCommande(id);
	}

	@Override
	public void modifierClient(Client c) {

		dao.modifierClient(c);
	}

	@Override
	public void supprimerClient(Long id) {
		dao.supprimerClient(id);
	}

	@Override
	public List<Categorie> listCategories() {
	
		return dao.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idCategorie) {
	
		return dao.getCategorie(idCategorie);
	}

	@Override
	public List<Article> listarticles() {
	
		return dao.listarticles();
	}

	@Override
	public List<Article> articlesParMotCle(String mc) {

		return dao.articlesParMotCle(mc);
	}

	@Override
	public List<Article> articlesParCategorie(Long idCategorie) {
		
		return dao.articlesParCategorie(idCategorie);
	}

	@Override
	public List<Article> articlesSelectionnes() {
		
		return dao.articlesSelectionnes();
	}

	@Override
	public Article getArticle(Long idArticle) {
		
		return dao.getArticle(idArticle);
	}

	@Override
	public Long ajouterCategorie(Categorie c) {
		
		return dao.ajouterCategorie(c);
	}

	@Override
	public void supprimerCategorie(Long idCategorie) {
		dao.supprimerCategorie(idCategorie);
		
	}

	@Override
	public void modifierCategorie(Categorie c) {
		
		dao.modifierCategorie(c);
	}

	@Override
	public Long ajouterArticle(Article a, Long idCategorie) {
	
		return dao.ajouterArticle(a, idCategorie);
	}

	@Override
	public void modifierArticle(Article a) {
	
		dao.modifierArticle(a);
	}

	@Override
	public void supprimerArticles(Long idArticle) {
	
		dao.supprimerArticles(idArticle);
	}

	@Override
	public void ajouterUser(User u) {
		
		dao.ajouterUser(u);
	}

	@Override
	public void supprimerUser(String username) {
	
		dao.supprimerUser(username);
	}

	@Override
	public void attribuerRole(Role r, Long id) {

		dao.attribuerRole(r, id);
	}

	@Override
	public void supprimerRoleUser(User u, Long role_id) {

		dao.supprimerRoleUser(u, role_id);
	}

	@Override
	public List<User> UtilisateurParMotCle(String mc) {
		return dao.UtilisateurParMotCle(mc);
	}

	@Override
	public List<User> UtilisateurParUsername(String username) {
		return dao.UtilisateurParUsername(username);
	}

	@Override
	public Long ajouterEvent(Event e) {
		return dao.ajouterEvent(e);
	}

	@Override
	public void modifierEvent(Event e) {
		dao.modifierEvent(e);
	}

	@Override
	public void supprimerEvent(Long idEvenement) {
		dao.supprimerEvent(idEvenement);
	}

	@Override
	public List<Event> listEvents() {
		return dao.listEvents();
	}

	@Override
	public List<Event> listEvents(Long id) {
		return dao.listEvents(id);
	}

	@Override
	public Event getEvent(Long idEvenement) {
		return dao.getEvent(idEvenement);
	}

	@Override
	public void affecterAgent(Long idEvenement, Long id) {
		dao.affecterAgent(idEvenement, id);
	}

	@Override
	public Long ajouterCommande( Commande c) {
		return dao.ajouterCommande(c);
	}

	@Override
	public void supprimerCommande(Long idCommande) {
		dao.supprimerCommande(idCommande);
	}

	@Override
	public List<Commande> findAllCommandesClients(Long numeroFiche) {
		return dao.findAllCommandesClients(numeroFiche);
	}

	@Override
	public List<Commande> findAllCommandesClients(Long numeroFiche, Date date) {
		return dao.findAllCommandesClients(numeroFiche, date);
	}

	@Override
	public List<Commande> findAllCommandesClients(Long numeroFiche, Boolean valide) {
		return dao.findAllCommandesClients(numeroFiche, valide);
	}

	@Override
	public List<Commande> findAllCommandesClients(Long numeroFiche, Date date, Boolean valide) {
		return dao.findAllCommandesClients(numeroFiche, date, valide);
	}

	@Override
	public List<Commande> findAllCommandesDuClient(Long numeroFiche, Long Id) {
		return dao.findAllCommandesDuClient(numeroFiche, Id);
	}

	@Override
	public List<Commande> findAllCommandesDuClient(Long numeroFiche, Date date, Long Id) {
		return dao.findAllCommandesDuClient(numeroFiche, date, Id);
	}

	@Override
	public List<Commande> findAllCommandesDuClient(Long numeroFiche, Boolean valide, Long Id) {
		return dao.findAllCommandesDuClient(numeroFiche, valide, Id);
	}

	@Override
	public List<Commande> findAllCommandesDuClient(Long numeroFiche, Date date, Boolean valide, Long Id) {
		return dao.findAllCommandesDuClient(numeroFiche, date, valide, Id);
	}

	@Override
	public Commande enregistrerCommande(PanierC p, Client c) {
		return dao.enregistrerCommande(p, c);
	}

	@Override
	public boolean accepterCommande(Long idCommande) {
		return dao.accepterCommande(idCommande);
	}

	@Override
	public Integer NbreCommande(Long numeroFiche) {
		return dao.NbreCommande(numeroFiche);
	}

	@Override
	public Integer NbreCommandeEntre(Date d1, Date d2) {
		return dao.NbreCommandeEntre(d1, d2);
	}

	@Override
	public Long ajouterAgent(Agent a) {
		return dao.ajouterAgent(a);
	}

	@Override
	public List<Agent> listAgents() {
		return dao.listAgents();
	}

	@Override
	public Long ajouterClient(Client c) {
		return dao.ajouterClient(c);
	}

	@Override
	public List<Client> listClients() {
		return dao.listClients();
	}

	@Override
	public List<Client> ClientParMotCle(String mc) {
		return dao.ClientParMotCle(mc);
	}

	@Override
	public List<Client> ClientParId(Long id) {
		return dao.ClientParId(id);
	}

	@Override
	public Long ajouterDevis(Devis d) {
		return dao.ajouterDevis(d);
	}

	@Override
	public void modifierDevis(Devis d) {
		dao.modifierDevis(d);
	}

	@Override
	public void supprimerDevis(Long idEvenement) {
		dao.supprimerDevis(idEvenement);
	}

	@Override
	public List<Devis> listDevis() {
		return dao.listDevis();
	}

	@Override
	public Devis getDevis(Long idEvenement) {
		return dao.getDevis(idEvenement);
	}

	@Override
	public Facture FactureClient(Long facture_id) {
		return dao.FactureClient(facture_id);
	}

	@Override
	public Facture PayerFacture(Long facture_id) {
		return dao.PayerFacture(facture_id);
	}

	@Override
	public List<Facture> RechercherFacturesDuClient(Long id) {
		return dao.RechercherFacturesDuClient(id);
	}

	@Override
	public List<Facture> RechercherFacturesClients(Long numeroFiche) {
		return dao.RechercherFacturesClients(numeroFiche);
	}

	@Override
	public List<Facture> RechercherFacturesClients(Long numeroFiche, Date facture_date) {
		return dao.RechercherFacturesClients(numeroFiche, facture_date);
	}

	@Override
	public List<Facture> RechercherFacturesClients(Long numeroFiche, Long idClient) {
		return dao.RechercherFacturesClients(numeroFiche, idClient);
	}

	@Override
	public List<Facture> RechercherFacturesClients(Long numeroFiche, Date facture_date, Long idClient) {
		return dao.RechercherFacturesClients(numeroFiche, facture_date, idClient);
	}

	@Override
	public Integer NbrFacture(Long numeroFiche) {
		return dao.NbrFacture(numeroFiche);
	}

	@Override
	public Integer NbrAchatsArticle(Long numeroFiche) {
		return dao.NbrAchatsArticle(numeroFiche);
	}

	@Override
	public Integer PrixAchatsArticle(Long numeroFiche) {
		return dao.PrixAchatsArticle(numeroFiche);
	}

	@Override
	public Integer CalculeVente(Long numeroFiche, Date facture_date, Date facture_date2) {
		return dao.CalculeVente(numeroFiche, facture_date, facture_date2);
	}

	@Override
	public Integer CalculePrixVente(Long numeroFiche, Date facture_date, Date facture_date2) {
		return dao.CalculePrixVente(numeroFiche, facture_date, facture_date2);
	}

	@Override
	public Integer CalculeVenteArticle(Long numeroFiche, Date facture_date, Date facture_date2, Long idArticle) {
		return dao.CalculeVenteArticle(numeroFiche, facture_date, facture_date2, idArticle);
	}

	@Override
	public Integer CalculePrixVenteArticle(Long numeroFiche, Date facture_date, Date facture_date2, Long idArticle) {
		return dao.CalculePrixVenteArticle(numeroFiche, facture_date, facture_date2, idArticle);
	}

	@Override
	public List<Object[]> CalculeArticleVendu(Long numeroFiche, Date facture_date, Date facture_date2) {
		return dao.CalculeArticleVendu(numeroFiche, facture_date, facture_date2);
	}

	@Override
	public List<Fiche> rechercheFicheParNom(String nomFiche) {
		return dao.rechercheFicheParNom(nomFiche);
	}

	@Override
	public List<Fiche> rechercheFicheParDateCreation(String nomFiche, Date dateCreation) {
		return dao.rechercheFicheParDateCreation(nomFiche, dateCreation);
	}

	@Override
	public List<Fiche> rechercheFicheParDateFermeture(String nomFiche, Date dateFermeture) {
		return dao.rechercheFicheParDateFermeture(nomFiche, dateFermeture);
	}

	@Override
	public List<Fiche> rechercheFicheParDateCreationFermeture(String nomFiche, Date dateFermeture, Date dateCreation) {
		return dao.rechercheFicheParDateCreationFermeture(nomFiche, dateFermeture, dateCreation);
	}

	@Override
	public List<Fiche> rechercheFicheCloturer(String nomFiche) {
		return dao.rechercheFicheCloturer(nomFiche);
	}

	@Override
	public List<Fiche> rechercheFicheNonCloturer(String nomFiche) {
		return dao.rechercheFicheNonCloturer(nomFiche);
	}

	@Override
	public LigneCommande rechercheLcParArticle(Long idCommande, String idArticle) {
		return dao.rechercheLcParArticle(idCommande, idArticle);
	}

	@Override
	public LigneFacture rechercheLfParDate(Date facture_date, Date facture_date2) {
		return dao.rechercheLfParDate(facture_date, facture_date2);
	}

	@Override
	public Role rechercherRole(String role_nom) {
		return dao.rechercherRole(role_nom);
	}

	@Override
	public Role rechercherRoleParId(Long role_id) {
		return null;
	}

	@Override
	public Role rechercherRoleParIdEtNom(Long role_id, String role_nom) {
		return null;
	}

	@Override
	public Long ajouterMariage(Mariage m) {
		return dao.ajouterMariage(m);
	}

	@Override
	public List<Mariage> listMariage() {
		return null;
	}

	@Override
	public void modifierMariage(Mariage m) {
		
	}

	@Override
	public void supprimerMariage(Long idEvenement) {
		
	}

	@Override
	public Long ajouterDote(Dote d) {
		return dao.ajouterDote(d);
	}

	@Override
	public List<Dote> listDote() {
		return dao.listDote();
	}

	@Override
	public void modifierDote(Dote d) {
		dao.modifierDote(d);
	}

	@Override
	public void supprimerDote(Long idEvenement) {
		dao.supprimerDote(idEvenement);
	}

	@Override
	public Long ajouterFiancaille(Fiancaille f) {
		return dao.ajouterFiancaille(f);
	}

	@Override
	public List<Fiancaille> listFiancaille() {
		return dao.listFiancaille();
	}

	@Override
	public void modifierFiancaille(Fiancaille f) {
		dao.modifierFiancaille(f);
	}

	@Override
	public void supprimerFiancaille(Long idEvenement) {
		dao.supprimerFiancaille(idEvenement);
	}

	@Override
	public Long ajouterGardenParty(GardenParty gp) {
		return dao.ajouterGardenParty(gp);
	}

	@Override
	public List<GardenParty> listGardenParty() {
		return dao.listGardenParty();
	}

	@Override
	public void modifierGardenParty(GardenParty gp) {
		dao.modifierGardenParty(gp);
	}

	@Override
	public void supprimerGardenParty(Long idEvenement) {
		dao.supprimerGardenParty(idEvenement);
	}

	@Override
	public Long ajouterPreciousTimes(PreciousTimes pt) {
		return dao.ajouterPreciousTimes(pt);
	}

	@Override
	public List<PreciousTimes> listPreciousTimes() {
		return dao.listPreciousTimes();
	}

	@Override
	public void modifierPreciousTimes(PreciousTimes pt) {
		dao.modifierPreciousTimes(pt);
	}

	@Override
	public void supprimerPreciousTimes(Long idEvenement) {
		dao.supprimerPreciousTimes(idEvenement);
	}

	@Override
	public Long ajouterSalle(Salle s) {
		return dao.ajouterSalle(s);
	}

	@Override
	public List<Salle> listSalle() {
		return dao.listSalle();
	}

	@Override
	public void modifierSalle(Salle s) {
		dao.modifierSalle(s);
	}

	@Override
	public void supprimerSalle(Long idSalle) {
		dao.supprimerSalle(idSalle);
	}

}
