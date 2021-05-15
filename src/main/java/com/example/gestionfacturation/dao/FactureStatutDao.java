package com.example.gestionfacturation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionfacturation.bean.FactureStatut;

@Repository
public interface FactureStatutDao extends JpaRepository<FactureStatut, Long> {
 public FactureStatut findByReference(String reference);
 public FactureStatut findByNom(String nom);

}
