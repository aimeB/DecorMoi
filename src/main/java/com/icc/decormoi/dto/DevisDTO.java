package com.icc.decormoi.dto;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import com.icc.decormoi.domaine.Client;
import com.icc.decormoi.domaine.Salle;

public class DevisDTO {
	
	private Long id;
	
	private Date date;
	
	private int nbrPersonne;
	
	private int nbrTable;
	
	private Enum typeEvent;
	
	private ClientDTO client;

	private SalleDTO salle;
	
	private String Remarque;
}
