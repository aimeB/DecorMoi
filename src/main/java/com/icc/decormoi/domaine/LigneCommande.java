package com.icc.decormoi.domaine;


import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity @Table( name = "T_LigneCommande")
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
}


