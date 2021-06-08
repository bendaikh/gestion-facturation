package com.example.gestionfacturation.service;

import com.example.gestionfacturation.dao.CommandeDao;
import com.example.gestionfacturation.bean.Client;
import com.example.gestionfacturation.bean.Commande;
import com.example.gestionfacturation.bean.CommandeStatut;
import com.example.gestionfacturation.bean.CommandeType;
import com.example.gestionfacturation.bean.Currency;
import com.example.gestionfacturation.bean.Expedition;

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
    
    public List<Commande> findAll() {
		return commandeDao.findAll();
	}

	public int save(Commande commande) {

        if (findByReference(commande.getReference())!=null){
            return -1;
        }
        Client client =clientService.findByReference(commande.getClient().getReference());
        commande.setClient(client);
        Currency currency=currencyService.findByCode(commande.getCurrency().getCode());
        commande.setCurrency(currency);
        CommandeStatut commandeStatut =commandeStatutService.findByCode(commande.getCommandestatut().getCode());
        commande.setCommandestatut(commandeStatut);
        CommandeType commandeType=commandeTypeService.findByCode(commande.getCommandeType().getCode());
        commande.setCommandeType(commandeType);
        Expedition expedition= expeditionService.findByCode(commande.getExpedition().getCode());
        commande.setExpedition(expedition);
        if(client==null) {
        	return -2;
        }
        if(currency==null) {
        	return -3;
        }
        if(commandeStatut==null) {
        	return -4;
        }
        if(commandeType==null) {
        	return -4;
        }
        if(expedition==null) {
        	return -6;
        }
        else{

            commandeDao.save(commande);         
            
            deliveryService.save(commande,commande.getDeliveries());
            return 1;
        }
    }
    public void update(Commande commande){
        commandeDao.save(commande);

    }
    @Autowired
    private CommandeStatutService commandeStatutService;
    @Autowired
    private CommandeTypeService commandeTypeService;
    @Autowired
    private ExpeditionService expeditionService;
    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private CommandeDao commandeDao;

    @Autowired
    private ClientService clientService;
    @Autowired
    private CurrencyService currencyService;
 

 }
