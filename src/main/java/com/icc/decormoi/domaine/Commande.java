package com.icc.decormoi.domaine;

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
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity @Table(name = "T_Commande")
public class Commande implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//ATTRIBUTS
	@Id @GeneratedValue
	private Long idCommande;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date dateCommande;
	
	@NotNull
	private boolean valide;
	
	
	
	
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
	private Fiche fiche;
	
	
	private double total;
	
	
}
