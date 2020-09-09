package com.icc.decormoi.domaine;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity @Table( name = "T_Salle")
public class Salle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 60)
	private String designation;
	
	@NotNull
	@Column(length = 60, unique = true, nullable = false)
	private String slug;
	
	
	@Column(length = 255)
	private String website;
	
	@Column(length = 30)
	private String phone;
	
	@Positive
	private Integer nbPlaces = 100;
	
	@OneToOne
	private Adresse adresse;
}
