package com.example.gestionfacturation.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.gestionfacturation.bean.Commande;
import com.example.gestionfacturation.bean.Facture;

@Repository
public interface FactureDao extends JpaRepository<Facture, Long> {
 public Facture findByReference(String reference);
 public int deleteByReference(String reference);
 @Query("select f from Facture f where f.reference LIKE %?1%")
 public List<Facture> findByRef(@Param("reference")String reference);
 public List<Facture> findByDateCreation(Date dateCreation);
 @Query("select count(f) from Facture f where f.commande.client.reference=:reference")
 public Integer count(@Param("reference")String reference);
 @Query("select f.commande from Facture f where f.reference=:reference")
 public Commande findCommandeByFactureReference(@Param("reference")String reference); 
}
