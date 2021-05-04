package com.example.gestionfacturation.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.gestionfacturation.enumeration.FactureStatut_name_eng;
import com.example.gestionfacturation.enumeration.FactureStatut_name_fre;
import com.example.gestionfacturation.enumeration.FactureStatut_name_spa;
@Entity
public class FactureStatut {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	private FactureStatut_name_eng factureStatut_name_eng ;
	private FactureStatut_name_fre FactureStatut_name_fre ;
	private FactureStatut_name_spa factureStatut_name_spa ;
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
	public FactureStatut_name_eng getFactureStatut_name_eng() {
		return factureStatut_name_eng;
	}
	public void setFactureStatut_name_eng(FactureStatut_name_eng factureStatut_name_eng) {
		this.factureStatut_name_eng = factureStatut_name_eng;
	}
	public FactureStatut_name_fre getFactureStatut_name_fre() {
		return FactureStatut_name_fre;
	}
	public void setFactureStatut_name_fre(FactureStatut_name_fre factureStatut_name_fre) {
		FactureStatut_name_fre = factureStatut_name_fre;
	}
	public FactureStatut_name_spa getFactureStatut_name_spa() {
		return factureStatut_name_spa;
	}
	public void setFactureStatut_name_spa(FactureStatut_name_spa factureStatut_name_spa) {
		this.factureStatut_name_spa = factureStatut_name_spa;
	}
	
	 
}
