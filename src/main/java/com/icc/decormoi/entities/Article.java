package com.icc.decormoi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Article")
public class Article implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idArticle;
	
	private String designation;
	private String description;
	private double prix;
	private String emplacement;
	private int quantite;
	private String image;
	private boolean selectionne;
	
	@ManyToOne
	@JoinColumn(name="idCategorie")
	private Categorie categorie;


	public Article() {
		super();	
	}

	public Article(String designation, String description, double prix, String emplacement, int quantite, String image
			, Categorie categorie) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.emplacement = emplacement;
		this.quantite = quantite;
		this.image = image;
		this.categorie = categorie;
	
	}

	public Long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isSelectionne() {
		return selectionne;
	}

	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", designation=" + designation + ", description=" + description
				+ ", prix=" + prix + ", emplacement=" + emplacement + ", quantite=" + quantite + ", image=" + image
				+ ", selectionne=" + selectionne + ", categorie=" + categorie + "]";
	}
	
	

}
