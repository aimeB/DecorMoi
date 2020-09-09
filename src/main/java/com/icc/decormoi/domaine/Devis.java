package com.icc.decormoi.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity @Table( name = "T_Devis")
public class Devis {
	
	
	//ATTRIBUTS
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NonNull
	private Date date;
	
	private int nbrPersonne;
	
	private int nbrTable;
	
	private Enum typeEnum;
	
	private String Remarque;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	@Nullable
	@NotFound(action = NotFoundAction.IGNORE)
	private Client client;
	
	
	@ManyToOne
	@JoinColumn(name="idSalle")
	@Nullable
	@NotFound(action = NotFoundAction.IGNORE)
	private Salle salle;
	
	
	
}