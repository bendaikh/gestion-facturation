package com.example.gestionfacturation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gestionfacturation.bean.Facture;
import com.example.gestionfacturation.bean.Paiment;
import com.example.gestionfacturation.dao.PaimentDao;

@Service
public class PaimentService {
@Autowired
private PaimentDao paimentDao;
@Autowired
private FactureService factureService;
@Autowired
private PaimentMethodeService paimentMethodeService;
@Autowired
private CurrencyService currencyService;
public Paiment findByReference(String reference) {
	return paimentDao.findByReference(reference);
}

public List<Paiment> findByFactureReference(String reference) {
	return paimentDao.findByFactureReference(reference);
}



public Double montantFacture(String reference) {
	return paimentDao.montantFacture(reference);
}

public List<Paiment> findAll() {
	return paimentDao.findAll();
}
@Transactional
public int deleteByFactureReference(String reference) {
	return paimentDao.deleteByFactureReference(reference);
}

public Integer count(String reference) {
	return paimentDao.count(reference);
}

	boolean save = true ;
	public int save(Paiment paiment) {
		
		if(save==true) {
			
		
		if(findByReference(paiment.getReference())!=null) {
			return -1;
		}}
		Facture facture= factureService.findByReference(paiment.getFacture().getReference());
		paiment.setFacture(facture);
		
		if(facture==null) {
			return -2;
		}
		
		else {
			
		prepare(paiment);
		
		paimentMethodeService.save(paiment.getPaimentMethode());
		currencyService.save(paiment.getCurrency());
		paimentDao.save(paiment);
		
		return 1;
		
		}
	}
	
	private void prepare(Paiment paiment) {
			double reste;
			
			double s=montantFacture(paiment.getFacture().getReference());
if(s==0) {
	reste=paiment.getFacture().getTotal()-paiment.getMontant();
	
}
else {
		reste=paiment.getFacture().getTotal()-s;
				}
paiment.setReste(reste);

	}
	public void update(Paiment paiment) {
		save=false;
		
		save(paiment);
		
	}

	public void save(Facture facture, List<Paiment> paiments) {
		for(Paiment paiment:paiments) {
			paiment.setFacture(facture);
			paimentDao.save(paiment);
		}
	}
	

}
