package com.example.gestionfacturation.dao;

import com.example.gestionfacturation.bean.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDao extends JpaRepository<Client,Long> {
    Client findByEmail(String email);
    Client findByReference(String reference);
    //finding clients using just the name
    @Query("select c from Client c where c.nom like :mc or c.email like :mc or c.pays like :mc")
    List<Client> listOfClients(@Param("mc") String mc);
    public int deleteByReference(String reference);

}
