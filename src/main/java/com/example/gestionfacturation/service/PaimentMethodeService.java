package com.example.gestionfacturation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionfacturation.bean.PaimentMethode;
import com.example.gestionfacturation.dao.PaimentMethodeDao;

@Service
public class PaimentMethodeService {
@Autowired
private PaimentMethodeDao paimentMethodeDao;

public PaimentMethode findByReference(String reference) {
	return paimentMethodeDao.findByReference(reference);
}

public PaimentMethode findByNom(String nom) {
	return paimentMethodeDao.findByNom(nom);
}

public List<PaimentMethode> findAll() {
	return paimentMethodeDao.findAll();
}
public int save (PaimentMethode paimentMethode) {
	if(findByReference(paimentMethode.getReference())!=null) {
		return -1;
	}
	else {
		paimentMethodeDao.save(paimentMethode);
		return 1;
	}
}
}
