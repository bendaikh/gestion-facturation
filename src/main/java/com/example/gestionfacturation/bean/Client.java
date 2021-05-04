package com.example.gestionfacturation.bean;


import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private String nom;
    private String legal_form;
    private String adresse1;
    private String adresse2;
    private String zip_code;
    private String ville;
    private String pays;
    private double number1;
    private double number2;
    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLegal_form() {
        return legal_form;
    }

    public void setLegal_form(String legal_form) {
        this.legal_form = legal_form;
    }

    public String getAdresse1() {
        return adresse1;
    }

    public void setAdresse1(String adresse1) {
        this.adresse1 = adresse1;
    }

    public String getAdresse2() {
        return adresse2;
    }

    public void setAdresse2(String adresse2) {
        this.adresse2 = adresse2;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public double getNumber1() {
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

    

    

	
}
