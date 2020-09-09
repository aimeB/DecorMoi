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
@AllArgsConstructor
@Data
@Entity 
@DiscriminatorValue("PRTI")
public class PreciousTimes extends Event implements Serializable {
	
	
	private final int prixParPersonne =25;
	private final int montantMin = 120;
	private final int coutFixe= nbPersonnes * prixParPersonne;
	private int coutFixePrecious;
}
