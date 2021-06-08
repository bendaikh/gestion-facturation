package com.example.gestionfacturation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionfacturation.bean.PaimentMethode;
import com.example.gestionfacturation.bean.PaimentStatut;
import com.example.gestionfacturation.dao.PaimentStatutDao;

@Service

public class PaimentStatutService {
	@Autowired
	private PaimentStatutDao paimentStatutDao;

	public PaimentStatut findByCode(String code) {
		return paimentStatutDao.findByCode(code);
	}

	public PaimentStatut findByNom(String nom) {
		return paimentStatutDao.findByNom(nom);
	}

	public List<PaimentStatut> findAll() {
		return paimentStatutDao.findAll();
	}
	public int save (PaimentStatut paimentStatut) {
		if(findByCode(paimentStatut.getCode())!=null) {
			return -1;
		}
		else {
			paimentStatutDao.save(paimentStatut);
			return 1;
		}
	}
}
