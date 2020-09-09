package com.icc.decormoi.dto;

import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.icc.decormoi.domaine.Categorie;
import com.icc.decormoi.domaine.Tva;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {
	
	private Long idArticle;
	
	private String designation;

	private double prix;

	private int quantite;
	
	private int quantiteAlerte;

	private byte image;
	
	private boolean selectionne;
	
	private CategorieDTO categorie;

	private TvaDTO tva;
}
