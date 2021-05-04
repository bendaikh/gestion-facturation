package com.example.gestionfacturation.bean;

import com.example.gestionfacturation.enumeration.CommandeType;
import com.example.gestionfacturation.enumeration.Commande_Status;
import com.example.gestionfacturation.enumeration.Expedition;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private CommandeType commandeType;
    private Expedition expedition;
    private Date date_Commande;
    private double montant;
    private String commentaire;
//    @OneToOne
//    private Devis devis;
   
    //private Agent agent;
    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;
    private Commande_Status commande_status;
	@OneToOne
    private Facture facture;
    
    public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	@ManyToOne(cascade = CascadeType.ALL)
    private Currency currency;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "commande")
    private List<Delivery> deliveries;

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

   

//    public Devis getDevis() {
//		return devis;
//	}
//
//	public void setDevis(Devis devis) {
//		this.devis = devis;
//	}

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

    public CommandeType getCommandeType() {
        return commandeType;
    }

    public void setCommandeType(CommandeType commandeType) {
        this.commandeType = commandeType;
    }

    public Expedition getExpedition() {
        return expedition;
    }

    public void setExpedition(Expedition expedition) {
        this.expedition = expedition;
    }

    public Date getDate_Commande() {
        return date_Commande;
    }

    public void setDate_Commande(Date date_Commande) {
        this.date_Commande = date_Commande;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Commande_Status getCommande_status() {
        return commande_status;
    }

    public void setCommande_status(Commande_Status commande_status) {
        this.commande_status = commande_status;
    }



    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
