package com.example.gestionfacturation.service;


import com.example.gestionfacturation.dao.DevisDao;
import com.example.gestionfacturation.bean.Commande;
import com.example.gestionfacturation.bean.CommandeType;
import com.example.gestionfacturation.bean.Currency;
import com.example.gestionfacturation.bean.Devis;
import com.example.gestionfacturation.bean.Expedition;
import com.example.gestionfacturation.bean.QuotationStatus;

import java.util.List;

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
    
    public List<Devis> findAll() {
		return devisDao.findAll();
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
        Expedition expedition = expeditionService.findByCode(devis.getExpedition().getCode());
        devis.setExpedition(expedition);
        CommandeType commandeType = commandeTypeService.findByCode(devis.getType().getCode());
        devis.setType(commandeType);
        if(currency==null) {
        	return -2;
        }
        if(quotationStatus==null) {
        	return-3;
        }
        if(commande==null) {
        	return -4;
        }
        if(expedition==null) {
        	return -5;
        }
        if(commandeType==null) {
        	return -6;
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
    @Autowired
    private ExpeditionService expeditionService;
    @Autowired
    private CommandeTypeService commandeTypeService;
}
