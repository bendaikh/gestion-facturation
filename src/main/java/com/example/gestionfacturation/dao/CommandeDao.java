package com.example.gestionfacturation.dao;

import com.example.gestionfacturation.bean.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeDao extends JpaRepository<Commande,Long> {
    public Commande findByReference(String reference);
    @Query("select c from Commande c where c.reference like :mc")
    public List<Commande> listCommandes(@Param("mc") String mc);
    public int deleteByReference(String reference);

}
