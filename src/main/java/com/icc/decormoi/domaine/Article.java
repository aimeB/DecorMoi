
package com.icc.decormoi.domaine;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity @Table( name = "T_Article")
public class Article implements Serializable {
	
	
	
	//ATTRIBUTS
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	private Long idArticle;
	
	@Size(min=2, max=1000)
	private String designation;
	
	@DecimalMin("0") 
	private double prix;
	
	@Min(0)
	private int quantite;
	
	@Min(0)
	private int quantiteAlerte;
	
	@Lob
	private byte image;
	
	
	private boolean selectionne;
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name="idCategorie", nullable = true)
	@NotFound(action = NotFoundAction.IGNORE)
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name="codeTVA", nullable=true)  
	@NotFound(action = NotFoundAction.IGNORE) 
	private Tva tva;


}
