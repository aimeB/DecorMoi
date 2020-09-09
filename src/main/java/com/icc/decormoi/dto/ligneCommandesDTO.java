package com.icc.decormoi.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.icc.decormoi.domaine.Article;
import com.icc.decormoi.domaine.Commande;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ligneCommandesDTO {
	
	private Long idLigneCom;
	
	private ArticleDTO article;
	
	private int qte;
	
	private double total;
	
	private double ttc;

}
