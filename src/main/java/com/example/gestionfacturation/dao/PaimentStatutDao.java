package com.example.gestionfacturation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionfacturation.bean.PaimentStatut;
@Repository
public interface PaimentStatutDao extends JpaRepository<PaimentStatut, Long>{
	 public PaimentStatut findByCode(String code);
	 public PaimentStatut findByNom(String nom);
}
