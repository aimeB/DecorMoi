package com.icc.decormoi.domaine;


import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity @Table( name = "T_Client")
@DiscriminatorValue("CLIENT")
public class Client extends User{
	
	@OneToMany(mappedBy = "client")
	@Nullable
	@NotFound(action = NotFoundAction.IGNORE)
	private List<Commande> commandes;
	
}
