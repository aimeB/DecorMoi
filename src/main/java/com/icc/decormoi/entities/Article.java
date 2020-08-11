package com.icc.decormoi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "Article")
public class Article implements Serializable {
	
	
	
	//ATTRIBUTS
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	private Long idArticle;
	
	@Size(min=2, max=1000)
	private String designation;
	
	@DecimalMin("0") 
	private double prix;
	
	@Min(0)
	private int quantite;
	
	@Min(0)
	private int quantiteAlerte;
	
	@Lob
	private byte image;
	
	private boolean selectionne;
	
	@ManyToOne
	@JoinColumn(name="idCategorie", nullable = true)
	@NotFound(action = NotFoundAction.IGNORE)
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name="codeTVA", nullable=true)  
	@NotFound(action = NotFoundAction.IGNORE) 
	private Tva tva;


	
	
	//CONSTRUCTEURS
	public Article() {
		super();	
	}


	public Article(Long idArticle, String designation, double prix, int quantite, int quantiteAlerte, byte image,
			boolean selectionne, Categorie categorie, Tva tva) {
		super();
		this.idArticle = idArticle;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.quantiteAlerte = quantiteAlerte;
		this.image = image;
		this.selectionne = selectionne;
		this.categorie = categorie;
		this.tva = tva;
	}


	public Article(String designation, double prix, int quantite, int quantiteAlerte,boolean selectionne,
			Categorie categorie, Tva tva) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.quantiteAlerte = quantiteAlerte;
		this.selectionne = selectionne;
		this.categorie = categorie;
		this.tva = tva;
	}



	//GETTER ET SETTER
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

	
	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}


	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public byte getImage() {
		return image;
	}

	public void setImage(byte image) {
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

	
	
	//TOSTRING
	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", designation=" + designation + ", description="
				+ ", prix=" + prix + ", emplacement=" + ", quantite=" + quantite + ", image=" + image
				+ ", selectionne=" + selectionne + ", categorie=" + categorie + "]";
	}
	
	

}
