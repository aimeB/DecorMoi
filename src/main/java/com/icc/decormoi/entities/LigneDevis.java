package com.icc.decormoi.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneDevis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigne;
	
	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;
	private int quantite;
	private double prix;
	
	public LigneDevis() {
		super();
	}

	public LigneDevis(Article article, int quantite, double prix) {
		super();
		this.article = article;
		this.quantite = quantite;
		this.prix = prix;
	}

	public Long getIdLigne() {
		return idLigne;
	}

	public void setIdLigne(Long idLigne) {
		this.idLigne = idLigne;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "LigneDevis [idLigne=" + idLigne + ", article=" + article + ", quantite=" + quantite + ", prix=" + prix
				+ "]";
	}
	
	

}
