package com.icc.decormoi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class UtilisateursRoles {
	

	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="username") 
	//@JsonIgnore
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	@NotFound(action = NotFoundAction.IGNORE)
	private Role role;
	
	public UtilisateursRoles() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	} 

}
