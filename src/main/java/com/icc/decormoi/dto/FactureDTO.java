package com.icc.decormoi.dto;

import java.util.Collection;
import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import com.icc.decormoi.domaine.Client;
import com.icc.decormoi.domaine.Commande;
import com.icc.decormoi.domaine.Fiche;
import com.icc.decormoi.domaine.LigneFacture;
import com.icc.decormoi.domaine.ReductionFacture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class FactureDTO {

	private Long facture_id;

	private Date facture_date;
	
	private double total;
	
	private double ttc;

	private Client client;
	
	private LigneFactureDTO lignesFacture;

	private ReductionFactureDTO reductions;
	
}
