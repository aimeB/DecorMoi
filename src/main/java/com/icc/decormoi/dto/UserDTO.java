package com.icc.decormoi.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.icc.decormoi.domaine.Adresse;
import com.icc.decormoi.domaine.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
	
	private Long id;
	
	protected static enum typeEvent{ADMIN, AGENT, CLIENT};
	
	private String login;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String langue;
	
	private Adresse adresse;

	private RoleDTO roles;
}
