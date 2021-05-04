package com.example.gestionfacturation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionfacturation.bean.FactureEtat;
import com.example.gestionfacturation.dao.FactureEtatDao;

@Service
public class FactureEtatService {
@Autowired
private FactureEtatDao factureEtatDao;

public FactureEtat findByReference(String reference) {
	return factureEtatDao.findByReference(reference);
}

public List<FactureEtat> findAll() {
	return factureEtatDao.findAll();
}
public int save(FactureEtat factureEtat) {
	if(findByReference(factureEtat.getReference())!=null) {
		return -1;
	}
	else {
		factureEtatDao.save(factureEtat);
		return 1;
	}
}
}
