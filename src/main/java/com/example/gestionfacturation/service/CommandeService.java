package com.example.gestionfacturation.service;

import com.example.gestionfacturation.dao.CommandeDao;
import com.example.gestionfacturation.bean.Client;
import com.example.gestionfacturation.bean.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommandeService {
    public Commande findByReference(String reference) {
        return commandeDao.findByReference(reference);
    }

    public List<Commande> listCommandes(String mc) {
        return commandeDao.listCommandes(mc);
    }
    @Transactional
    public int deleteByReference(String reference) {
        return commandeDao.deleteByReference(reference);
    }

    public int save(Commande commande) {

        if (findByReference(commande.getReference())!=null){
            return -1;
        }
        Client client =clientService.findByReference(commande.getClient().getReference());
        commande.setClient(client);
        if(client==null) {
        	return -2;
        }
        else{
            currencyService.save(commande.getCurrency());
            factureService.saveS(commande.getFacture());

            commandeDao.save(commande);         
            
            deliveryService.save(commande,commande.getDeliveries());
            return 1;
        }
    }
    public void update(Commande commande){
        commandeDao.save(commande);

    }
    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private CommandeDao commandeDao;

    @Autowired
    private ClientService clientService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private FactureService factureService;


 }
