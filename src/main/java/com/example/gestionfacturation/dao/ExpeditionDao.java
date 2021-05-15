package com.example.gestionfacturation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionfacturation.bean.Expedition;

@Repository
public interface ExpeditionDao extends JpaRepository<Expedition,Long> {
	public  Expedition findByCode(String code);
	public  Expedition findByNom(String nom);


}
