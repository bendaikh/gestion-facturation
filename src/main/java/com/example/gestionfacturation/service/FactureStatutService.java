package com.example.gestionfacturation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionfacturation.bean.FactureStatut;
import com.example.gestionfacturation.dao.FactureStatutDao;

@Service
public class FactureStatutService {
@Autowired
private FactureStatutDao factureStatutDao;

public FactureStatut findByReference(String reference) {
	return factureStatutDao.findByReference(reference);
}

public List<FactureStatut> findAll() {
	return factureStatutDao.findAll();
}

public FactureStatut findByNom(String nom) {
	return factureStatutDao.findByNom(nom);
}

public int save(FactureStatut factureStatut) {
	if(findByReference(factureStatut.getReference())!=null) {
		return -1;
	}
	else {
		factureStatutDao.save(factureStatut);
		return 1;
	}
}
}
