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

@Entity
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String user_name;
	private String user_password;
	private boolean actif;
	
	@OneToMany
	@JoinColumn(name="id")
	private Collection<Rôle> rôles;
	
	@OneToMany
	@JoinColumn(name="id")
	private Collection<Permission> permission;
	
	public Utilisateur() {
		super();
		
	}

	public Utilisateur(Long id, String user_name, String user_password, boolean actif, Collection<Rôle> rôles,
			Collection<Permission> permission) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.actif = actif;
		this.rôles = rôles;
		this.permission = permission;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Collection<Rôle> getRôles() {
		return rôles;
	}

	public void setRôles(Collection<Rôle> rôles) {
		this.rôles = rôles;
	}

	public Collection<Permission> getPermission() {
		return permission;
	}

	public void setPermission(Collection<Permission> permission) {
		this.permission = permission;
	}

}
