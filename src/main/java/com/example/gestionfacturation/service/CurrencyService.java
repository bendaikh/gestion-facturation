package com.example.gestionfacturation.service;

import com.example.gestionfacturation.dao.CurrencyDao;
import com.example.gestionfacturation.bean.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {
    public Currency findByCode(String code) {
        return currencyDao.findByCode(code);
    }

    public List<Currency> listOfCurrency(String mc) {
        return currencyDao.listOfCurrency(mc);
    }

    public Currency findByNom(String nom) {
		return currencyDao.findByNom(nom);
	}

	public int deleteByCode(String code) {
        return currencyDao.deleteByCode(code);
    }

    public int save(Currency currency) {
        if (findByCode(currency.getCode())!=null){
            return -1;
        }
        else{
            currencyDao.save(currency);
            return 1;
        }

    }

    @Autowired
    private CurrencyDao currencyDao;
}
