package com.example.gestionfacturation.service;


import com.example.gestionfacturation.dao.DevisDao;
import com.example.gestionfacturation.bean.Devis;
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
        else {


            currencyService.save(devis.getCurrency());
            quotationStatusService.save(devis.getQuotation_status());
            commandeService.save(devis.getCommande());
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
