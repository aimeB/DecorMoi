package com.icc.decormoi.domaine;


import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PanierC implements Serializable{
	
	private Devis devis;
	
	private Map<Long, LigneCommande> items = new HashMap<Long, LigneCommande>();
	
	public void addItem( Article ar) {
		
		LigneCommande lc = items.get(ar.getIdArticle());
		
		if(lc==null && ar.getDesignation()== "Menu individuel" || ar.getDesignation()== "Carte de remerciement individuelle") {
			LigneCommande art = new LigneCommande();
			art.setArticle(ar);
			art.setQte(devis.getNbrPersonne());
			art.setTtc(ar.getPrix());
			items.put(ar.getIdArticle(), art);
		}
		else if (lc==null && ar.getDesignation()== "Menus Table") {
			LigneCommande art = new LigneCommande();
			art.setArticle(ar);
			art.setQte(devis.getNbrTable());
			art.setTtc(ar.getPrix());
			items.put(ar.getIdArticle(), art);
		}
		else if (lc==null && ar.getDesignation()== "Bouquet" ) {
				LigneCommande art = new LigneCommande();
				art.setArticle(ar);
				art.setQte(devis.getNbrTable()/2);
				art.setTtc(ar.getPrix());
				items.put(ar.getIdArticle(), art);	
		}
		else if (lc==null && ar.getDesignation()== "Décoration voiture" || ar.getDesignation()== "Panneau d’accueil" || ar.getDesignation()== "Plan de table" || ar.getDesignation()== "Décoration église" || ar.getDesignation()== "Mur de fleur" || ar.getDesignation()== "Drapé") {
			LigneCommande art = new LigneCommande();
			art.setArticle(ar);
			art.setTtc(ar.getPrix());
			items.put(ar.getIdArticle(), art);
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


