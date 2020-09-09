package com.icc.decormoi.domaine;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Entity @Table( name = "T_ReductionFacture")
public class ReductionFacture 
{
	@Id @GeneratedValue
	private Long id;


	@ManyToOne
	@JoinColumn(name="ID_REDUCTION")
	private Reduction reduction;
	 
	private Double taux;
	
	
	@ManyToOne
	@JoinColumn(name="NUM_FACTURE")
	private Facture facture;
}