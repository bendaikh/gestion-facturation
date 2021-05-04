package com.example.gestionfacturation.service;


import com.example.gestionfacturation.dao.QuotationStatusDao;
import com.example.gestionfacturation.bean.QuotationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationStatusService {
    public List<QuotationStatus> listOfQuotationStatus(String mc) {
        return quotationStatusDao.listOfQuotationStatus(mc);
    }

    public int deleteByCode(String code) {
        return quotationStatusDao.deleteByCode(code);
    }

    public QuotationStatus findByCode(String code) {
        return quotationStatusDao.findByCode(code);
    }

    public int save(QuotationStatus quotationStatus) {
    	if(findByCode(quotationStatus.getCode())!=null) {
    		return -1;
    	}
    	else {
    		quotationStatusDao.save(quotationStatus);
    		return 1;
    	}
         
    }

    @Autowired
   private  QuotationStatusDao quotationStatusDao;

}
