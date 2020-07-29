package com.icc.decormoi.entities;


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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
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
	
	//CONSTRUCTEURS
	
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Facture(Date facture_date, double total, double ttc, Commande commande) {
		super();
		this.facture_date = facture_date;
		this.total = total;
		this.ttc = ttc;
		this.commande = commande;
	}



	//GETTER ET SETTER
	public Date getFacture_date() {
		return facture_date;
	}

	

	public void setFacture_date(Date facture_date) {
		this.facture_date = facture_date;
	}

	public Long getFacture_id() {
		return facture_id;
	}

	public void setFacture_id(Long facture_id) {
		this.facture_id = facture_id;
	}

	//TOSTRING
	@Override
	public String toString() {
		return "Facture [facture_id=" + facture_id + ", facture_date=" + facture_date + "]";
	}

}
