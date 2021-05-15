package com.example.gestionfacturation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionfacturation.bean.FactureEtat;

@Repository
public interface FactureEtatDao extends JpaRepository<FactureEtat,Long> {
 public FactureEtat findByReference(String reference);
 public FactureEtat findByNom(String nom);

}
