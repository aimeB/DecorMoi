package com.icc.decormoi.entities;


import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PanierC implements Serializable{
	
	private Map<Long, LigneCommande> items = new HashMap<Long, LigneCommande>();
	public void addItem(Article ar, int quantite) {
		LigneCommande lc = items.get(ar.getIdArticle());
		if(lc==null) {
			LigneCommande art = new LigneCommande();
			art.setArticle(ar);
			art.setQte(quantite);
			art.setTtc(ar.getPrix());
			items.put(ar.getIdArticle(), art);
		}
		else {
			lc.setQte(lc.getQte()+ quantite);
		}
	}
	
	public Collection <LigneCommande> getItems(){
		
		return items.values();
	}
	
	public double getTotal() {
		double total =0;
		for(LigneCommande lc:items.values()) {
			total+=lc.getTtc()*lc.getQte();
		}
		return total;
	}
	
	public int getSize() {
		return items.size();
	}
	
	public void deleteItem(Long idProduit) {
		items.remove(idProduit);
	}
}


