package com.icc.decormoi.domaine;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity @Table( name = "T_Fiche")
public class Fiche  implements Serializable
{
	
	//ATTRIBUTS
	@Id  @GeneratedValue
	private Long numeroFiche;
	
	@Size(min=3, max=25)
	private String nomFiche;
 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateCreation;
	 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Nullable
	private Date dateFermeture;
	
	@ManyToOne
	@JoinColumn(name="username") 
	@NotFound(action = NotFoundAction.IGNORE)
	private User user;
}