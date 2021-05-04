package com.example.gestionfacturation.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Delivery implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    //private Delivery_Statut delivery_statut;
    private Date creation_date;
    private Date delivery_date;
    private Long cmr_Number;
    private String cmr_Commodity;
    private String cmr_Shipper;
    private String cmr_Shipping_Adress;
    private String cmr_Recipient;
    private String cmr_Recipient_Address;
    @ManyToOne
    private Commande commande;
    //private Travel travel;


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

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public Long getCmr_Number() {
        return cmr_Number;
    }

    public void setCmr_Number(Long cmr_Number) {
        this.cmr_Number = cmr_Number;
    }

    public String getCmr_Commodity() {
        return cmr_Commodity;
    }

    public void setCmr_Commodity(String cmr_Commodity) {
        this.cmr_Commodity = cmr_Commodity;
    }

    public String getCmr_Shipper() {
        return cmr_Shipper;
    }

    public void setCmr_Shipper(String cmr_Shipper) {
        this.cmr_Shipper = cmr_Shipper;
    }

    public String getCmr_Shipping_Adress() {
        return cmr_Shipping_Adress;
    }

    public void setCmr_Shipping_Adress(String cmr_Shipping_Adress) {
        this.cmr_Shipping_Adress = cmr_Shipping_Adress;
    }

    public String getCmr_Recipient() {
        return cmr_Recipient;
    }

    public void setCmr_Recipient(String cmr_Recipient) {
        this.cmr_Recipient = cmr_Recipient;
    }

    public String getCmr_Recipient_Address() {
        return cmr_Recipient_Address;
    }

    public void setCmr_Recipient_Address(String cmr_Recipient_Address) {
        this.cmr_Recipient_Address = cmr_Recipient_Address;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
