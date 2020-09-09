package com.icc.decormoi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategorieDTO {
	
	private Long idCategorie;
	
	private String nomCategorie;
	private String description;
	private String nomPhoto;

	private byte[] image;
	
	private ArticleDTO article;
	

}
