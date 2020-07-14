package com.icc.decormoi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Permission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPermission;
	private String nomPermission;
	private String description;
	
	
	public Permission() {
		super();
	}

	public Permission(String permission_nom, String description) {
		super();
		this.nomPermission = permission_nom;
		this.description = description;
	}

	public String getPermission_nom() {
		return nomPermission;
	}

	public void setPermission_nom(String permission_nom) {
		this.nomPermission = permission_nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getIdPermission() {
		return idPermission;
	}

	public void setIdPermission(Long idPermission) {
		this.idPermission = idPermission;
	}

	public String getNomPermission() {
		return nomPermission;
	}

	public void setNomPermission(String nomPermission) {
		this.nomPermission = nomPermission;
	}

}
