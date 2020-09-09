package com.icc.decormoi.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity @Table( name = "T_Categorie")
public class Categorie implements Serializable {
	
	@Id
	@GeneratedValue
	private Long idCategorie;
	
	private String nomCategorie;
	private String description;
	private String nomPhoto;
	@Lob
	private byte[] image;
	
	@OneToMany(mappedBy="categorie")
	private Collection<Article> articles = new ArrayList<Article>();
	
}
