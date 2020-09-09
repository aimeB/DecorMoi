package com.icc.decormoi.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommandeDTO {
	
	private Long idCommande;
	
	private Date dateCommande;
	
	private boolean valide;
	
	private ClientDTO client;
	
	private ligneCommandesDTO ligneCommande;

	private FicheDTO fiche;
	
	private double total;

}
