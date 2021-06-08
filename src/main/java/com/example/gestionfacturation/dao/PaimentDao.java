package com.example.gestionfacturation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.gestionfacturation.bean.Facture;
import com.example.gestionfacturation.bean.Paiment;

@Repository
public interface PaimentDao extends JpaRepository<Paiment, Long> {
 public Paiment findByReference(String reference);
 public List<Paiment> findByFactureReference(String reference);
 int deleteByFactureReference(String reference);
 @Query("select coalesce(sum(p.montant),0) from Paiment p where p.facture.reference=:reference")
 public Double montantFacture(@Param("reference")String reference);
 @Query("select count(p) from Paiment p where p.facture.reference=:reference")
 public Integer count(@Param("reference")String reference);
   @Query("select p.facture from Paiment p where p.reference=:reference")
   public Facture findFactureByPaimentReference(@Param("reference")String reference);
   int deleteByReference(String reference);
}
