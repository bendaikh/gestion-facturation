package com.example.gestionfacturation.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.gestionfacturation.enumeration.PaimentMethode_name_eng;
import com.example.gestionfacturation.enumeration.PaimentMethode_name_fre;
import com.example.gestionfacturation.enumeration.PaimentMethode_name_spa;

@Entity
public class PaimentMethode {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	private PaimentMethode_name_eng paimentMethode_name_eng  ;
	private PaimentMethode_name_fre paimentMethode_name_fre ;
	private PaimentMethode_name_spa paimentMethode_name_spa ;
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
	
	
	public PaimentMethode_name_eng getPaimentMethode_name_eng() {
		return paimentMethode_name_eng;
	}
	public void setPaimentMethode_name_eng(PaimentMethode_name_eng paimentMethode_name_eng) {
		this.paimentMethode_name_eng = paimentMethode_name_eng;
	}
	public PaimentMethode_name_spa getPaimentMethode_name_spa() {
		return paimentMethode_name_spa;
	}
	public void setPaimentMethode_name_spa(PaimentMethode_name_spa paimentMethode_name_spa) {
		this.paimentMethode_name_spa = paimentMethode_name_spa;
	}
	public PaimentMethode_name_fre getPaimentMethode_name_fre() {
		return paimentMethode_name_fre;
	}
	public void setPaimentMethode_name_fre(PaimentMethode_name_fre paimentMethode_name_fre) {
		this.paimentMethode_name_fre = paimentMethode_name_fre;
	}
	
	
}
