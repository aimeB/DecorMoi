package com.icc.decormoi.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.icc.decormoi.domaine.Facture;
import com.icc.decormoi.domaine.Reduction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReductionFactureDTO {
	
	private Long id;

	private ReductionDTO reduction;
	 
	private Double taux;
}
