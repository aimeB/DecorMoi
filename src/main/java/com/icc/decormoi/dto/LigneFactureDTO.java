package com.icc.decormoi.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.icc.decormoi.domaine.Article;
import com.icc.decormoi.domaine.Facture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LigneFactureDTO {
	
	private Long idLiFa;

	private ArticleDTO article;
	
	private int qte;
	
	private double prix; 
	
	private double total;
	
	private double ttc;

}
