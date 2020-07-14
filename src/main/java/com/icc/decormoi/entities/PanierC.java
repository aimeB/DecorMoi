package com.icc.decormoi.entities;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PanierC implements Serializable{
	
	private Map<Long, LigneCommande> items = new HashMap<Long, LigneCommande>();
	public void addItem(Article ar, int quantite) {
		LigneCommande lc = items.get(ar.getIdArticle());
		if(lc==null) {
			LigneCommande art = new LigneCommande();
			art.setArticle(ar);
			art.setQuantite(quantite);
			art.setPrix(ar.getPrix());
			items.put(ar.getIdArticle(), art);
		}
		else {
			lc.setQuantite(lc.getQuantite()+ quantite);
		}
	}

}
