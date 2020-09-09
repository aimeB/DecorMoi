package com.icc.decormoi.domaine;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@DiscriminatorValue("MARI")
public class Mariage extends Event implements Serializable {
	
	
	
	//ATTRIBUT

	
	protected final int prixParPersonne= 15;
	
	protected final int coutFixeMariage = nbPersonnes * prixParPersonne ;

}
