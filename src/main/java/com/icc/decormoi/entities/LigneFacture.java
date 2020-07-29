package com.icc.decormoi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class LigneFacture {

	@Id @GeneratedValue
	private Long idLiFa;
	
	@ManyToOne
	@JoinColumn(name="NUM_FACTURE")
	private Facture facture; 
	
	@ManyToOne
	@JoinColumn(name="REF_PRODUIT")
	@NotFound(action = NotFoundAction.IGNORE)
	private Article article;
	
	private int qte;
	
	private double prix; 
	
	private double total;
	
	private double ttc;
	  
	
	public LigneFacture() {}

	public LigneFacture(Facture fact,  Article article, int qte, double prix) {
		super();  
		facture = fact; 
		this.article = article;
		this.qte = qte;
		this.prix = prix;
	}

	
	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}
 

	public Long getIdLiFa() {
		return idLiFa;
	}

	public void setIdLiFa(Long idLiFa) {
		this.idLiFa = idLiFa;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTtc() {
		return ttc;
	}

	public void setTtc(double ttc) {
		this.ttc = ttc;
	} 
	
}
