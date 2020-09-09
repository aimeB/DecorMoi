package com.icc.decormoi.domaine;


import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity @Table( name = "T_Facture")
public class Facture implements Serializable {
	
	
	//ATTRIBUT
	@Id @GeneratedValue
	@Column(name = "facture_id")
	private Long facture_id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date facture_date;
	
	private double total;
	
	private double ttc;
	
	@ManyToOne
	@JoinColumn(name="CODE_CLIENT")
	@Nullable
	@NotFound(action = NotFoundAction.IGNORE)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="idCommande")
	private Commande commande;
	
	
	@OneToMany(mappedBy="facture",fetch=FetchType.LAZY)
	private Collection<LigneFacture> lignesFacture;

	@OneToMany(mappedBy="facture",fetch=FetchType.LAZY)
	private Collection<ReductionFacture> reductions;

	@ManyToOne
	@JoinColumn(name="numeroFiche")
	@NotFound(action = NotFoundAction.IGNORE)
	private Fiche fichier;
	
	
}
