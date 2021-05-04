package com.example.gestionfacturation.dao;


import com.example.gestionfacturation.bean.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryDao extends JpaRepository<Delivery,Long> {
    public Delivery findByReference(String reference);

    @Query("select d from Delivery d where d.reference like :mc or d.cmr_Commodity like :mc or d.cmr_Shipper like :mc")
    public List<Delivery> listOfDeliveries(@Param("mc") String mc);

    public int deleteByReference(String reference);

}
