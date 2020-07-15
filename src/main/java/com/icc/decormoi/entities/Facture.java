package com.icc.decormoi.entities;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Entity;

@Entity
public class Facture {
	
	@Id @GeneratedValue
	@Column(name = "facture_id")
	private Long facture_id;
	
	private Date facture_date;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Evenement event;
	
	
	public Facture() {
		super();
	}

	public Facture(Date facture_date) {
		super();
		this.facture_date = facture_date;
	}

	public Date getFacture_date() {
		return facture_date;
	}

	public void setFacture_date(Date facture_date) {
		this.facture_date = facture_date;
	}

	public Long getFacture_id() {
		return facture_id;
	}

	public void setFacture_id(Long facture_id) {
		this.facture_id = facture_id;
	}

	@Override
	public String toString() {
		return "Facture [facture_id=" + facture_id + ", facture_date=" + facture_date + ", event=" + event + "]";
	}
	
	

}
