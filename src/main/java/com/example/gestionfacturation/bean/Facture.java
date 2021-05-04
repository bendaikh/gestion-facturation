package com.example.gestionfacturation.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.sun.istack.NotNull;

@Entity
public class Facture {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateCreation;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateEchaence;
	private double prix;
	private double quantite;
	private double totalHt;
	private double remise_val;
	private float remise_pourcentage;
	private double tva_val;
	private float tva_pourcentage;
	private double totalHtnet;
	private double total;
	private int cdtpaiment;
	private String notes;
	private String commentaire;
	private boolean transmise;
	private boolean comptabilise;
	private boolean en_litige;
//	@ManyToOne
//	private FactureEtat factureEtat;
//	@ManyToOne
//	private FactureStatut factureStatut;
//	@JsonProperty(access =  JsonProperty.Access.WRITE_ONLY)
//	@OneToMany(mappedBy = "facture")
//	private List<Paiment> paiments;
//	
//	public List<Paiment> getPaiments() {
//		return paiments;
//	}
//	public void setPaiments(List<Paiment> paiments) {
//		this.paiments = paiments;
//	}
	@ManyToOne(cascade = CascadeType.ALL)
	private Client client;
	
		@ManyToOne(cascade = CascadeType.ALL)
	private Currency currency;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Devis devis;
	
	public Devis getDevis() {
		return devis;
	}
	public void setDevis(Devis devis) {
		this.devis = devis;
	}
	@OneToOne
	@NotNull
	private Commande commande;
	
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public int getCdtpaiment() {
		return cdtpaiment;
	}
	public void setCdtpaiment(int cdtpaiment) {
		this.cdtpaiment = cdtpaiment;
	}
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
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDateEchaence() {
		return dateEchaence;
	}
	public void setDateEchaence(Date dateEchaence) {
		this.dateEchaence = dateEchaence;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public double getQuantite() {
		return quantite;
	}
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getRemise_val() {
		return remise_val;
	}
	public void setRemise_val(double remise_val) {
		this.remise_val = remise_val;
	}
	public float getRemise_pourcentage() {
		return remise_pourcentage;
	}
	public void setRemise_pourcentage(float remise_pourcentage) {
		this.remise_pourcentage = remise_pourcentage;
	}
	public double getTva_val() {
		return tva_val;
	}
	public void setTva_val(double tva_val) {
		this.tva_val = tva_val;
	}
	public float getTva_pourcentage() {
		return tva_pourcentage;
	}
	public void setTva_pourcentage(float tva_pourcentage) {
		this.tva_pourcentage = tva_pourcentage;
	}
	
	public double getTotalHt() {
		return totalHt;
	}
	public void setTotalHt(double totalHt) {
		this.totalHt = totalHt;
	}
	public double getTotalHtnet() {
		return totalHtnet;
	}
	public void setTotalHtnet(double totalHtnet) {
		this.totalHtnet = totalHtnet;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public boolean isTransmise() {
		return transmise;
	}
	public void setTransmise(boolean transmise) {
		this.transmise = transmise;
	}
	public boolean isComptabilise() {
		return comptabilise;
	}
	public void setComptabilise(boolean comptabilise) {
		this.comptabilise = comptabilise;
	}
	public boolean isEn_litige() {
		return en_litige;
	}
	public void setEn_litige(boolean en_litige) {
		this.en_litige = en_litige;
	}
//	public FactureEtat getFactureEtat() {
//		return factureEtat;
//	}
//	public void setFactureEtat(FactureEtat factureEtat) {
//		this.factureEtat = factureEtat;
//	}
//	public FactureStatut getFactureStatut() {
//		return factureStatut;
//	}
//	public void setFactureStatut(FactureStatut factureStatut) {
//		this.factureStatut = factureStatut;
//	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
}
