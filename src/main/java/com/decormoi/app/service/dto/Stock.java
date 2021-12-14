package com.decormoi.app.service.dto;

import com.decormoi.app.domain.Produit;

import java.util.HashMap;
import java.util.Map;

public class Stock {

    //Pour la quantité
    private Map<String, Integer> map = new HashMap<>();

    //Idem, mais pour le pourcentage
    private Map<String, Double> map2 = new HashMap<>();

    public void setQuantity(Produit produit, Integer qty){
        map.put(produit.getNom(), qty);
        map2.put(produit.getNom(), (qty/ Double.valueOf(produit.getQuantity()))*100);
    }

    public Integer getQuantity(Produit produit){
        return map.get(produit.getNom());
    }

    public Map<String, Integer> getMapQuantity() {
        return map;
    }

    public Map<String, Double> getMapPourcentage() {
        return map2;
    }
}
