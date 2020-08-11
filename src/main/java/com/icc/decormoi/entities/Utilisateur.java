package com.icc.decormoi.entities;


import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Utilisateur {

	
	//ATTRIBUTS
	@Id @NotNull @Size(min=4,max=50)
	private String username;
	
	@Size(min=4,max=50)
	@JsonIgnore
	private String password;
	
	private boolean actif = false;
	
	@OneToMany(mappedBy="utilisateur", fetch = FetchType.LAZY)
	private Collection<UtilisateursRoles> roles;
	
	//CONSTRUCTEUR
	public Utilisateur() {
		super();
		
	}

	public Utilisateur(String username, String password, boolean actif) {
		super();
		this.username = username;
		this.password = password;
		this.actif = actif;
	}


	
	
	//GETTER ET SETTER
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<UtilisateursRoles> getRoles() {
		return roles;
	}

	public void setRoles(Collection<UtilisateursRoles> roles) {
		this.roles = roles;
	}

	public boolean getActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}  

	
	
	//TOSTRING
	@Override
	public String toString() { 
		
		return username; 
	}
}
