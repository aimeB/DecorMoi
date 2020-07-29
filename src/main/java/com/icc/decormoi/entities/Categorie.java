package com.icc.decormoi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Categorie implements Serializable {
	
	@Id
	@GeneratedValue
	private Long idCategorie;
	
	private String nomCategorie;
	private String description;
	private String nomPhoto;
	@Lob
	private byte[] image;
	
	@OneToMany(mappedBy="categorie")
	private Collection<Article> articles = new ArrayList<Article>();
	
	public Categorie() {
		super();
		
	}

	public Categorie(String nomCategorie, String description, String nomPhoto, byte[] image) {
		super();
		this.nomCategorie = nomCategorie;
		this.description = description;
		this.nomPhoto = nomPhoto;
		this.image = image;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNomPhoto() {
		return nomPhoto;
	}

	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nomCategorie=" + nomCategorie + ", description="
				+ description + ", nomPhoto=" + nomPhoto + ", image=" + Arrays.toString(image) + ", articles="
				+ articles + "]";
	}
	
	

}
