package com.example.gestionfacturation.bean;
import com.example.gestionfacturation.enumeration.CommandeType;
import com.example.gestionfacturation.enumeration.Expedition;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Devis implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private Date date_devis;
    private Expedition expedition;
    private String commerciale;
    private CommandeType type;
    private Date date_echange;
    private String depart;
    private String arrive;
    private double prix;
    private float quantity;
    private double remise_val;
    private int remise_pourcentage;
    private float tva_valeur;
    private float tva_pourcentage;
    private double montant;
    private double totalPayer;
    private String note;
    private String commentaire;
    private Date date_creation;
    @OneToOne
    private Commande commande;
    
    @ManyToOne
    private Currency currency;
    @ManyToOne
    private QuotationStatus quotation_status;
 
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

    public Date getDate_devis() {
        return date_devis;
    }

    public void setDate_devis(Date date_devis) {
        this.date_devis = date_devis;
    }

    public Expedition getExpedition() {
        return expedition;
    }

    public void setExpedition(Expedition expedition) {
        this.expedition = expedition;
    }

 
    public String getCommerciale() {
        return commerciale;
    }

    public void setCommerciale(String commerciale) {
        this.commerciale = commerciale;
    }

    public CommandeType getType() {
        return type;
    }

    public void setType(CommandeType type) {
        this.type = type;
    }

    public Date getDate_echange() {
        return date_echange;
    }

    public void setDate_echange(Date date_echange) {
        this.date_echange = date_echange;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrive() {
        return arrive;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public double getRemise_val() {
        return remise_val;
    }

    public void setRemise_val(double remise_val) {
        this.remise_val = remise_val;
    }

    public int getRemise_pourcentage() {
        return remise_pourcentage;
    }

    public void setRemise_pourcentage(int remise_pourcentage) {
        this.remise_pourcentage = remise_pourcentage;
    }

    public float getTva_valeur() {
        return tva_valeur;
    }

    public void setTva_valeur(float tva_valeur) {
        this.tva_valeur = tva_valeur;
    }

    public float getTva_pourcentage() {
        return tva_pourcentage;
    }

    public void setTva_pourcentage(float tva_pourcentage) {
        this.tva_pourcentage = tva_pourcentage;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getTotalPayer() {
        return totalPayer;
    }

    public void setTotalPayer(double totalPayer) {
        this.totalPayer = totalPayer;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public QuotationStatus getQuotation_status() {
        return quotation_status;
    }


    public void setQuotation_status(QuotationStatus quotation_status) {
		this.quotation_status = quotation_status;
	}

	public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
