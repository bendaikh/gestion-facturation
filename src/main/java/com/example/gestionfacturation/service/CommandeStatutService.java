package com.example.gestionfacturation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionfacturation.bean.CommandeStatut;
import com.example.gestionfacturation.dao.CommandeStatutDao;

@Service
public class CommandeStatutService {
	@Autowired
	private CommandeStatutDao commandeStatutDao;

	public CommandeStatut findByCode(String code) {
		return commandeStatutDao.findByCode(code);
	}
	  public int save(CommandeStatut commandeStatut) {
	    	if(findByCode(commandeStatut.getCode())!=null) {
	    		return -1;
	    	}
	    	else {
	    		commandeStatutDao.save(commandeStatut);
	    		return 1;
	    	}
	         
	    }

	public CommandeStatut findByNom(String nom) {
		return commandeStatutDao.findByNom(nom);
	}
	public List<CommandeStatut> findAll() {
		return commandeStatutDao.findAll();
	}
	
}
