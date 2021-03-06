package com.example.gestionfacturation.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Paiment {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date datePaiment;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateCreation;
	private double montant;
	private String commentaire;
	private boolean comptabilise;
	private boolean enregistre;
	private double reste;
	private String paimentStatut;
	@ManyToOne
	private Facture facture;
	@ManyToOne
	private PaimentMethode paimentMethode;
	
	
	
	
	public String getPaimentStatut() {
		return paimentStatut;
	}
	public void setPaimentStatut(String paimentStatut) {
		this.paimentStatut = paimentStatut;
	}
	public double getReste() {
		return reste;
	}
	public void setReste(double reste) {
		this.reste = reste;
	}

	
	public PaimentMethode getPaimentMethode() {
		return paimentMethode;
	}
	public void setPaimentMethode(PaimentMethode paimentMethode) {
		this.paimentMethode = paimentMethode;
	}
	public Long getId() {
		return id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDatePaiment() {
		return datePaiment;
	}
	public void setDatePaiment(Date datePaiment) {
		this.datePaiment = datePaiment;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public boolean isComptabilise() {
		return comptabilise;
	}
	public void setComptabilise(boolean comptabilise) {
		this.comptabilise = comptabilise;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public boolean isEnregistre() {
		return enregistre;
	}
	public void setEnregistre(boolean enregistre) {
		this.enregistre = enregistre;
	}
	
	
}
