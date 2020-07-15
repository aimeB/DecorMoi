package com.icc.decormoi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rôle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long role_id;
	private String role_nom;
	private String description;
	
	
	public Rôle() {
		super();
	}


	public Rôle(String role_nom, String description) {
		super();
		this.role_nom = role_nom;
		this.description = description;
	}


	public String getRole_nom() {
		return role_nom;
	}


	public void setRole_nom(String role_nom) {
		this.role_nom = role_nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}


	@Override
	public String toString() {
		return "Rôle [role_id=" + role_id + ", role_nom=" + role_nom + ", description=" + description + "]";
	}

}
