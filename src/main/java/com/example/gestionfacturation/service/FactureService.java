package com.example.gestionfacturation.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.gestionfacturation.enumeration.FactureStatut;
import com.example.gestionfacturation.bean.Client;
import com.example.gestionfacturation.bean.Commande;
import com.example.gestionfacturation.bean.Currency;
import com.example.gestionfacturation.bean.Devis;
import com.example.gestionfacturation.bean.Facture;
import com.example.gestionfacturation.bean.FactureEtat;
import com.example.gestionfacturation.enumeration.FactureStatut;
import com.example.gestionfacturation.bean.Paiment;
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

	public Commande findCommandeByFactureReference(String reference) {
		return factureDao.findCommandeByFactureReference(reference);
	}

	

	

	@Transactional
	public int deleteByReference(String reference) {
		int p = paimentService.deleteByFactureReference(reference);
		int f = factureDao.deleteByReference(reference);
		return	p+f;
		 
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


	boolean save = true;

	public int save(Facture facture) {
		if (save == true) {
			if (findByReference(facture.getReference()) != null) {
				return -1;
			}
		}
		Commande commande = commandeService.findByReference(facture.getCommande().getReference());
		facture.setCommande(commande);
		Devis devis = devisService.findByReference(facture.getDevis().getReference());
		facture.setDevis(devis);
		FactureEtat factureEtat =factureEtatService.findByReference(facture.getFactureEtat().getReference());
		facture.setFactureEtat(factureEtat);
//		FactureStatut factureStatut= factureStatutService.findByReference(facture.getFactureStatut().getReference());
//		facture.setFactureStatut(factureStatut);
		Currency currency=currencyService.findByCode(facture.getCurrency().getCode());
		facture.setCurrency(currency);		
		if (devis == null) {
			return -3;
		}

		if (commande == null) {
			return -4;
		}
		if(factureEtat==null) {
			return -5;
		}
		//if(factureStatut==null) {
	//		return -6;
	//	}
		if(currency==null) {
			return -7;
		}
		prepare(facture);

		factureDao.save(facture);
		paimentService.save(facture,facture.getPaiments());
		return 1;

	}

	private int prepare(Facture facture) {
		double total = 0;
		double totalHt = 0;
		double totalHtnet = 0;
		double reste = 0;
		totalHt = facture.getPrix() * facture.getQuantite();
		if (facture.getRemise_val() != 0 && facture.getRemise_pourcentage() == 0) {
			totalHtnet = totalHt - facture.getRemise_val();
		} else if (facture.getRemise_val() == 0 && facture.getRemise_pourcentage() != 0) {
			totalHtnet = totalHt * (1 - facture.getRemise_pourcentage() / 100);
		} else {
			return -5;
		}
		if (facture.getTva_pourcentage() != 0 && facture.getTva_val() == 0) {
			total = totalHtnet + totalHtnet * facture.getTva_pourcentage() / 100;
		} else if (facture.getTva_pourcentage() == 0 && facture.getTva_val() != 0) {
			total = totalHtnet + facture.getTva_val();
		} else if (facture.getTva_pourcentage() == 0 && facture.getTva_val() == 0) {
			total = totalHtnet;
		}

		else {
			return -6;
		}
		facture.setTotalHt(totalHt);
		facture.setTotalHtnet(totalHtnet);
		facture.setTotal(total);
		for(Paiment paiment: facture.getPaiments()) {
			reste=reste+paiment.getMontant();
		}
		reste= facture.getTotal()-reste;
		facture.setReste(reste);
		if(facture.isEn_litige()== false) {
			if(facture.getPaiments().isEmpty()== true ) {
				FactureStatut factureStatut = FactureStatut.Non_payée;
				String s = factureStatut.getName();
				facture.setFactureStatut(s);
			}
			else if (facture.getReste()>0 && facture.getReste()!=0  ) {
				FactureStatut factureStatut = FactureStatut.Partiellement_payée;
				String s = factureStatut.getName();
				facture.setFactureStatut(s);
			}
			else if(facture.getReste()== 0 ) {
				FactureStatut factureStatut = FactureStatut.Payée;
				String s = factureStatut.getName();
				facture.setFactureStatut(s);
			}
		}
		else  {
			FactureStatut factureStatut = FactureStatut.En_litige;
			String s = factureStatut.getName();
			facture.setFactureStatut(s);
		}
		return 1;
	}

	public void update(Facture facture) {
		save = false;
		save(facture);
	}
}
