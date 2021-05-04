package com.example.gestionfacturation.bean;

import com.example.gestionfacturation.enumeration.Quotation_status_name_eng;
import com.example.gestionfacturation.enumeration.Quotation_status_name_fre;
import com.example.gestionfacturation.enumeration.Quotation_status_name_spa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class QuotationStatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private Quotation_status_name_eng quotation_status_name_eng;
    private Quotation_status_name_fre quotation_status_name_fre;
    private Quotation_status_name_spa quotation_status_name_spa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Quotation_status_name_eng getQuotation_status_name_eng() {
        return quotation_status_name_eng;
    }

    public void setQuotation_status_name_eng(Quotation_status_name_eng quotation_status_name_eng) {
        this.quotation_status_name_eng = quotation_status_name_eng;
    }

    public Quotation_status_name_fre getQuotation_status_name_fre() {
        return quotation_status_name_fre;
    }

    public void setQuotation_status_name_fre(Quotation_status_name_fre quotation_status_name_fre) {
        this.quotation_status_name_fre = quotation_status_name_fre;
    }

    public Quotation_status_name_spa getQuotation_status_name_spa() {
        return quotation_status_name_spa;
    }

    public void setQuotation_status_name_spa(Quotation_status_name_spa quotation_status_name_spa) {
        this.quotation_status_name_spa = quotation_status_name_spa;
    }
}
