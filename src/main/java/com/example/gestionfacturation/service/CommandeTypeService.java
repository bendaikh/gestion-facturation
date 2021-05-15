package com.example.gestionfacturation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionfacturation.bean.CommandeType;
import com.example.gestionfacturation.dao.CommandeTypeDao;

@Service
public class CommandeTypeService {
	@Autowired
	private CommandeTypeDao commandeTypeDao;

	public CommandeType findByCode(String code) {
		return commandeTypeDao.findByCode(code);
	}

	 public CommandeType findByNom(String nom) {
		return commandeTypeDao.findByNom(nom);
	}

	public int save(CommandeType commandeType) {
	    	if(findByCode(commandeType.getCode())!=null) {
	    		return -1;
	    	}
	    	else {
	    		commandeTypeDao.save(commandeType);
	    		return 1;
	    	}
	         
	    }
	public List<CommandeType> findAll() {
		return commandeTypeDao.findAll();
	}
	
}
