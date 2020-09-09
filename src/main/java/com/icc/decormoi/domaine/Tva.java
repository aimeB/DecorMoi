package com.icc.decormoi.domaine;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity @Table( name = "T_Tva")
public class Tva implements Serializable
{
	@Id @GeneratedValue 
	private Long codeTVA; 
	
	
	private String designation;
	
	
	private float taux;
}
