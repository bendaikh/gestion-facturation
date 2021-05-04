package com.example.gestionfacturation.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gestionfacturation.bean.Client;
import com.example.gestionfacturation.bean.Commande;
import com.example.gestionfacturation.bean.Devis;
import com.example.gestionfacturation.bean.Facture;
import com.example.gestionfacturation.bean.FactureEtat;
import com.example.gestionfacturation.bean.FactureStatut;
import com.example.gestionfacturation.dao.FactureDao;

@Service
public class FactureService {
@Autowired
private FactureDao factureDao;
@Autowired
private ClientService clientService;
@Autowired
private FactureEtatService factureEtatService;
@Autowired
private FactureStatutService factureStatutService;
@Autowired
private PaimentService paimentService;
@Autowired
private CommandeService commandeService;
@Autowired
private DevisService devisService;
@Autowired
private CurrencyService currencyService;
public Facture findByReference(String reference) {
	return factureDao.findByReference(reference);
}
@Transactional
public int deleteByReference(String reference) {
	int p=paimentService.deleteByFactureReference(reference);
	int f= factureDao.deleteByReference(reference);
	return f+p;
}

public List<Facture> findByRef(String reference) {
	return factureDao.findByRef(reference);
}
public Integer count(String reference) {
	return factureDao.count(reference);
}

public List<Facture> findByDateCreation(Date dateCreation) {
	return factureDao.findByDateCreation(dateCreation);
}
public List<Facture> findAll() {
	return factureDao.findAll();
}
public int saveS(Facture facture) {

Client client =clientService.findByReference(facture.getClient().getReference());
	facture.setClient(client);

	if(client==null) {
		return -2;
	}
	else {

		prepare(facture);
		currencyService.save(facture.getCurrency());
		
	    factureDao.save(facture);
	return 1;
	}
}
boolean save =true;
public int save(Facture facture) {
	if(save==true) {
		
	
	if(findByReference(facture.getReference())!=null) {
		return -1;
	}
	}
	Client client =clientService.findByReference(facture.getClient().getReference());
	facture.setClient(client);
	Commande commande = commandeService.findByReference(facture.getCommande().getReference());
	facture.setCommande(commande);
	Devis devis=devisService.findByReference(facture.getDevis().getReference());
	facture.setDevis(devis);

	if(client==null) {
		return -2;
	}
	if(devis==null) {
		return -3;
	}

	if(commande==null) {
		return -4;
	}
		prepare(facture);
		currencyService.save(facture.getCurrency());
		factureEtatService.save(facture.getFactureEtat());
		factureStatutService.save(facture.getFactureStatut());
	    factureDao.save(facture);
	    paimentService.save(facture,facture.getPaiments());
	return 1;
	
}
private int prepare(Facture facture) {
 double total =0;
 double totalHt=0;
 double totalHtnet =0;
 totalHt =facture.getPrix()*facture.getQuantite();
 if(facture.getRemise_val()!=0 && facture.getRemise_pourcentage()==0) {
	 totalHtnet=totalHt-facture.getRemise_val();
 }
 else if(facture.getRemise_val()==0 && facture.getRemise_pourcentage()!=0) {
 totalHtnet=totalHt*(1-facture.getRemise_pourcentage()/100);
 } else {
 return -5;
 }
 if(facture.getTva_pourcentage()!=0 && facture.getTva_val()==0) {
	 total=totalHtnet+totalHtnet*facture.getTva_pourcentage()/100;
 }
 else if(facture.getTva_pourcentage()==0 && facture.getTva_val()!=0){
	 total=totalHtnet+facture.getTva_val();
 }
 else if(facture.getTva_pourcentage()==0 && facture.getTva_val()==0) {
	 total =totalHtnet;
 }
 
 else {
	 return -6;
 }
 facture.setTotalHt(totalHt);
 facture.setTotalHtnet(totalHtnet);
 facture.setTotal(total);
 return 1;
}
public void update(Facture facture) {
	save=false;
	save(facture);
}
}
