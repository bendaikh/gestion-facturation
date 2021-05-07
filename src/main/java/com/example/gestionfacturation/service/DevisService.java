package com.example.gestionfacturation.service;


import com.example.gestionfacturation.dao.DevisDao;
import com.example.gestionfacturation.bean.Commande;
import com.example.gestionfacturation.bean.Currency;
import com.example.gestionfacturation.bean.Devis;
import com.example.gestionfacturation.bean.QuotationStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevisService {
    public Devis findByReference(String reference) {
        return devisDao.findByReference(reference);
    }

    public int deleteByReference(String reference) {
        return devisDao.deleteByReference(reference);
    }

    public int save(Devis devis) {
        if (findByReference(devis.getReference())!=null){
            return -1;
        }
        Currency currency=currencyService.findByCode(devis.getCurrency().getCode());
        devis.setCurrency(currency);
        QuotationStatus quotationStatus=quotationStatusService.findByCode(devis.getQuotation_status().getCode());
        devis.setQuotation_status(quotationStatus);
        Commande commande =commandeService.findByReference(devis.getCommande().getReference());
        devis.setCommande(commande);
        if(currency==null) {
        	return -2;
        }
        if(quotationStatus==null) {
        	return-3;
        }
        if(commande==null) {
        	return -4;
        }
        else {
        	        devisDao.save(devis);
            return 1;
        }

    }
    @Autowired
    private QuotationStatusService quotationStatusService;
    @Autowired
    private CommandeService commandeService;

    @Autowired
    private DevisDao devisDao;

    @Autowired
    private CurrencyService currencyService;

}
