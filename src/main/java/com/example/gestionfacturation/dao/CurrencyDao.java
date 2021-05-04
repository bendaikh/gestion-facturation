package com.example.gestionfacturation.dao;


import com.example.gestionfacturation.bean.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyDao extends JpaRepository<Currency,Long> {
    public Currency findByCode(String code);
    @Query("select c from Currency c where c.code like :mc")
    public List<Currency> listOfCurrency(@Param("mc") String mc);
    public int deleteByCode(String code);

}
