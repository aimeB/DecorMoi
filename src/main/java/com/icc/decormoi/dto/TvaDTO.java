package com.icc.decormoi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TvaDTO {
	
	private Long codeTVA; 
	
	
	private String designation;
	
	
	private float taux;

}
