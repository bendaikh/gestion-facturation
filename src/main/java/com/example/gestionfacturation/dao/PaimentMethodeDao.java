package com.example.gestionfacturation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionfacturation.bean.PaimentMethode;

@Repository
public interface PaimentMethodeDao extends JpaRepository<PaimentMethode, Long> {
 public PaimentMethode findByReference(String reference);
 public PaimentMethode findByNom(String nom);

}
