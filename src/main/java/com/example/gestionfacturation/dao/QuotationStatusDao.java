package com.example.gestionfacturation.dao;

import com.example.gestionfacturation.bean.QuotationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuotationStatusDao extends JpaRepository<QuotationStatus,Long> {
    @Query("select q from QuotationStatus q where q.code like :mc")
    public List<QuotationStatus> listOfQuotationStatus(@Param("mc") String mc);
    public int deleteByCode(String code);
    public QuotationStatus findByCode(String code);

}
