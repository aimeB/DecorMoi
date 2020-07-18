package com.icc.decormoi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public enum TypeEvent {
	
	PRIVE("Mariage", "Fiancaille","Dote", "Precious Time","Garden Party"),
	PROFESSIONEL("Diner d'afffaires","Fete du personnel","Decoration de boutique","Autres");

	
	@Id @GeneratedValue
	private int idEnum;
	private String choix1 = "";
	private String choix2 = "";
	private String choix3 = "";
	private String choix4 = "";
	private String choix5 = "";
	
	private TypeEvent(String choix1, String choix2, String choix3, String choix4, String choix5) {
		this.choix1 = choix1;
		this.choix2 = choix2;
		this.choix3 = choix3;
		this.choix4 = choix4;
		this.choix5 = choix5;
	}

	private TypeEvent(String choix1, String choix2, String choix3, String choix4) {
		this.choix1 = choix1;
		this.choix2 = choix2;
		this.choix3 = choix3;
		this.choix4 = choix4;
	}

	public String getChoix1() {
		return choix1;
	}

	public void setChoix1(String choix1) {
		this.choix1 = choix1;
	}

	public String getChoix2() {
		return choix2;
	}

	public void setChoix2(String choix2) {
		this.choix2 = choix2;
	}

	public String getChoix3() {
		return choix3;
	}

	public void setChoix3(String choix3) {
		this.choix3 = choix3;
	}

	public String getChoix4() {
		return choix4;
	}

	public void setChoix4(String choix4) {
		this.choix4 = choix4;
	}

	public String getChoix5() {
		return choix5;
	}

	public void setChoix5(String choix5) {
		this.choix5 = choix5;
	}
	
}
