package com.icc.decormoi.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import com.sun.istack.NotNull;


@Entity
public class Commande implements Serializable{
	
	
	
	//ATTRIBUTS
	@Id @GeneratedValue
	private Long idCommande;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateCommande;
	
	@NotNull
	private boolean valide;
	
	@OneToOne
	private Evenement evenement;
	

	@ManyToOne
	@JoinColumn(name="idClient")
	@Nullable
	@NotFound(action = NotFoundAction.IGNORE)
	private Client client;
	
	
	@OneToMany(mappedBy="commande", fetch = FetchType.LAZY)
	private Collection<LigneCommande> ligneCommandes;
	
	@ManyToOne
	@JoinColumn(name="numeroFiche")
	@NotFound(action = NotFoundAction.IGNORE)
	private Fiche fichier;
	
	
	private double total;
	
	
	//CONSTRUCTEURS
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}


	//GETTER ET SETTER
	

	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Evenement getEvenement() {
		return evenement;
	}

	public void setEvenement(Evenement evenement) {
		evenement = evenement;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(Collection<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
	public boolean isValide() {
		return valide;
	}


	public void setValide(boolean valide) {
		this.valide = valide;
	}


	//TOSTRING
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String c = client!=null?"Cliet:"+client.getNom():"";
		String e = evenement!=null?"Evenement:"+evenement.getNomEvent():"";
		
		String res = "{id:"+idCommande+", date:"+dateCommande+", Valide:"+valide+", "+
		c+e+"}";
		return res;
	}
}
