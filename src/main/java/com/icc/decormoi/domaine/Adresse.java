package com.icc.decormoi.domaine;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
	import org.springframework.lang.NonNull;

	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;
	
	@Entity @Table( name = "T_Adresse")
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class Adresse {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		
		@NonNull @NotNull
		@Column(length=60, nullable=false, unique=true)
		private String rue;
		
		
		@NonNull @NotNull
		@Column(length=6, nullable=false, unique=true)
		private String postalCode;
		
		@NonNull @NotNull
		@Column(length=60, nullable=false, unique=true)
		private String locality;
	}