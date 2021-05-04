package com.example.gestionfacturation.dao;

import com.example.gestionfacturation.bean.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevisDao extends JpaRepository<Devis,Long> {
    Devis findByReference(String reference);
    int deleteByReference(String reference);

}
