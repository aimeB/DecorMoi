package com.icc.decormoi.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.icc.decormoi.domaine.Adresse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalleDTO {
	
	private Long id;

	private String designation;

	private String slug;
	

	private String website;

	private String phone;

	private Integer nbPlaces = 100;
	

	private AdresseDTO adresse;

}
