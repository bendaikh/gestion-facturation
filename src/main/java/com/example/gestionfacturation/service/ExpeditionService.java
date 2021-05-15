package com.example.gestionfacturation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionfacturation.bean.Expedition;
import com.example.gestionfacturation.dao.ExpeditionDao;
@Service
public class ExpeditionService {
	@Autowired
	private ExpeditionDao expeditionDao;

	public Expedition findByCode(String code) {
		return expeditionDao.findByCode(code);
	}

	public int save(Expedition expedition) {
		if(findByCode(expedition.getCode())!=null) {
			return -1;
		}
		else {
			expeditionDao.save(expedition);
			return 1;
		}
	     
	}

	public Expedition findByNom(String nom) {
		return expeditionDao.findByNom(nom);
	}

	public List<Expedition> findAll() {
		return expeditionDao.findAll();
	}
}
