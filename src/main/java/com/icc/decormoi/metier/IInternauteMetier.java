package com.icc.decormoi.metier;

import java.util.List;

import com.icc.decormoi.entities.Article;
import com.icc.decormoi.entities.Categorie;
import com.icc.decormoi.entities.Devis;


public interface IInternauteMetier {
	
	//Gestion des Catégories
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCategorie);
	
	//Gestion des Articles
	public List<Article> listarticles();
	public List<Article> articlesParMotCle(String mc);
	public List<Article> articlesParCategorie(Long idCategorie);
	public List<Article> articlesSelectionnes();
	public Article getArticle(Long idArticle);
	
	//Gestion des Devis
	public Long ajouterDevis(Devis d);
	public void modifierDevis (Devis d);
}
