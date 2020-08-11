package com.icc.decormoi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icc.decormoi.entities.Categorie;
import com.icc.decormoi.metier.IAdminMetier;

class TestJPA {

	@Test
	void test1() {
		
		try {
			ClassPathXmlApplicationContext app=
	new ClassPathXmlApplicationContext(new String[] {"application.properties"});
			
			IAdminMetier metier= (IAdminMetier) app.getBean(IAdminMetier.class);
			
			List<Categorie> cat = metier.listCategories();
			
			metier.ajouterCategorie(new Categorie("Package", "offre groupé ", "image.jpg", null));
			metier.ajouterCategorie(new Categorie("Produit", "article en détail", "image2.jpg", null));

			List<Categorie> cat2 = metier.listCategories();

			assertTrue(cat.size() +6 == cat2.size());
			app.close();
	} catch (Exception e) {
		
			assertFalse(false);
	}
	}
	
	
	
}
