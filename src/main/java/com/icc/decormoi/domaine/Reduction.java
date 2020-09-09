package com.icc.decormoi.domaine;

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
@Entity @Table( name = "T_Reduction")
public class Reduction 
{
	
	@Id @GeneratedValue
	private Long id_reduc;
	
	private String type;  
}
