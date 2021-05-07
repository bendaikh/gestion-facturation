package com.example.gestionfacturation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionfacturation.bean.CommandeStatut;

@Repository
public interface CommandeStatutDao extends JpaRepository<CommandeStatut,Long> {
	public  CommandeStatut findByCode(String code);
}
