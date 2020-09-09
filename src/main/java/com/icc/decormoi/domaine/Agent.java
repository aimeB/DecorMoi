package com.icc.decormoi.domaine;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity @Table( name = "T_Agent")
@DiscriminatorValue("AGENT")
public class Agent extends User {
	
	@ManyToMany
	@JoinTable(name = "T_Agent_Event", 
			   joinColumns = @JoinColumn(name = "idUser", referencedColumnName = "id",
		               nullable = false, updatable = false), 
			   inverseJoinColumns = @JoinColumn(name = "idEvent", referencedColumnName = "id",
		               nullable = false, updatable = false))
	private List<Agent> events;
	

}
