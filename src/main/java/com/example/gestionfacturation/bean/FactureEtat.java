package com.example.gestionfacturation.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.gestionfacturation.enumeration.FactureEtat_name_eng;
import com.example.gestionfacturation.enumeration.FactureEtat_name_fre;
import com.example.gestionfacturation.enumeration.FactureEtat_name_spa;

@Entity
public class FactureEtat {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	private FactureEtat_name_eng factureEtat_name_eng ;
	private FactureEtat_name_fre factureEtat_name_fre ;
	private FactureEtat_name_spa factureEtat_name_spa ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public FactureEtat_name_eng getFactureEtat_name_eng() {
		return factureEtat_name_eng;
	}
	public void setFactureEtat_name_eng(FactureEtat_name_eng factureEtat_name_eng) {
		this.factureEtat_name_eng = factureEtat_name_eng;
	}
	public FactureEtat_name_fre getFactureEtat_name_fre() {
		return factureEtat_name_fre;
	}
	public void setFactureEtat_name_fre(FactureEtat_name_fre factureEtat_name_fre) {
		this.factureEtat_name_fre = factureEtat_name_fre;
	}
	public FactureEtat_name_spa getFactureEtat_name_spa() {
		return factureEtat_name_spa;
	}
	public void setFactureEtat_name_spa(FactureEtat_name_spa factureEtat_name_spa) {
		this.factureEtat_name_spa = factureEtat_name_spa;
	}
	
	
}
