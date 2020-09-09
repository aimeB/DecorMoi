package com.icc.decormoi.dto;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import com.icc.decormoi.domaine.User;

public class FicheDTO {
	
	private Long numeroFiche;
	
	private String nomFiche;

	private Date dateCreation;
	
	private Date dateFermeture;
	
	private UserDTO user;
}
