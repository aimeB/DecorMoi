package com.icc.decormoi.domaine;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Entity @Table( name = "T_LigneFacture")
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
}
