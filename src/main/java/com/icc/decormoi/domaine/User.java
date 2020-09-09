package com.icc.decormoi.domaine;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity @Table( name = "T_User")
@Inheritance ( strategy =  InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_USER", length= 6)
public class User {

	//ATTRIBUTS
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=30, nullable=false, unique=true)
	private Long id;
	
	protected static enum typeEvent{ADMIN, AGENT, CLIENT};
	
	@NonNull
	@Column(length=30, nullable=false, unique=true)
	private String login;
	
	@Size(min=4,max=50)
	@JsonIgnore
	private String password;
	
	@Column(length=60)
	private String firstName;
	
	@Column(length=60)
	private String lastName;
	
	@NonNull
	@Column(length=100, nullable=false)
	private String email;
	
	@Column(length=2)
	private String langue;
	
	
	@OneToOne
	@JoinColumn(name = "idAdresse", nullable = false)
	private Adresse adresse;
	

	@ManyToMany (fetch = FetchType.LAZY)
	@JoinTable(name = "T_User_Role", 
			   joinColumns = @JoinColumn(name = "User_id", referencedColumnName = "id",
               nullable = false, updatable = false), 
			   inverseJoinColumns = @JoinColumn(name = "Role_id", referencedColumnName = "id",
               nullable = false, updatable = false))
	private List<Role> roles;
}
