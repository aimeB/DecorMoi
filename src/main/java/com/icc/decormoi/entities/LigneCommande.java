package com.icc.decormoi.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
@Entity
public class LigneCommande  implements Serializable
{
	@Id @GeneratedValue
	private Long idLigneCom;
	
	@ManyToOne
	@JoinColumn(name="NUM_COMMANDE")
	private Commande commande;
	
	@ManyToOne
	@JoinColumn(name="idArticle")
	@NotFound(action = NotFoundAction.IGNORE)
	private Article article;
	
	private int qte;
	
	private double total;
	
	private double ttc;
	
	
	
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneCommande(Commande commande, Article article, int qte) {
		super();
		this.commande = commande;
		this.article = article;
		this.qte = qte;
	}

	public Long getId() {
		return idLigneCom;
	}

	public void setId(Long idLigneCom) {
		this.idLigneCom = idLigneCom;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Article getProduit() {
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return article+" : "+qte;
	}
}


