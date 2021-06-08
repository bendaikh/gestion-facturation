package com.example.gestionfacturation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gestionfacturation.bean.Currency;
import com.example.gestionfacturation.bean.Facture;
import com.example.gestionfacturation.bean.Paiment;
import com.example.gestionfacturation.bean.PaimentMethode;
import com.example.gestionfacturation.enumeration.PaimentStatut;
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
private PaimentStatutService paimentStatutService;
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

	public Facture findFactureByPaimentReference(String reference) {
	return paimentDao.findFactureByPaimentReference(reference);
}
	@Transactional
	public int deleteByReference(String reference) {
		return paimentDao.deleteByReference(reference);
	}

	boolean save = true ;
	public int save(Paiment paiment) {
		
		if(save==true) {
			
		
		if(findByReference(paiment.getReference())!=null) {
			return -1;
		}}
		Facture facture = factureService.findByReference(paiment.getFacture().getReference());
		paiment.setFacture(facture);
		PaimentMethode paimentMethode=paimentMethodeService.findByReference(paiment.getPaimentMethode().getReference());
		paiment.setPaimentMethode(paimentMethode);
		//PaimentStatut paimentStatut = paimentStatutService.findByCode(paiment.getPaimentStatut().getCode());
		//paiment.setPaimentStatut(paimentStatut);
		
		if(paimentMethode==null) {
			return -3;
		}
//		if(paimentStatut==null) {
//			return -4;
//		}
		else {
			
			prepare(paiment);
		paimentDao.save(paiment);
		
		return 1;	
		}
	}
	
	private void prepare(Paiment paiment) {
		double reste =0;
		reste = paiment.getFacture().getTotal()- paiment.getMontant();
		paiment.setReste(reste);
		if(paiment.isEnregistre()==true ) {
			PaimentStatut paimentStatut = PaimentStatut.Enregistré;
			String s = paimentStatut.name();
			paiment.setComptabilise(false);
			paiment.setPaimentStatut(s);
		}
		else if(paiment.isComptabilise()==true ) {
			PaimentStatut paimentStatut = PaimentStatut.Comptabilisé;
			String s = paimentStatut.name();
			paiment.setEnregistre(false);
			paiment.setPaimentStatut(s);
		}
	}
	public void update(Paiment paiment) {
		save=false;
		
		save(paiment);
		
	}

	public void save(Facture facture, List<Paiment> paiments) {
		for(Paiment paiment:paiments) {
			paiment.setFacture(facture);
			if(paiment.getFacture().getReference() == null) {
				save(paiment);
			}
			else {
			update(paiment);
			}
		}
	}

	

}
