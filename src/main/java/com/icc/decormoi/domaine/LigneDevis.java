package com.icc.decormoi.domaine;


import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity @Table( name = "T_LigneDevis")
public class LigneDevis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigne;
	
	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;
	
	private int quantite;
	
	private double prix;
	
	@ManyToOne
	@JoinColumn(name="NUM_DEVIS")
	private Devis devis;
	
	
}
