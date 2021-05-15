package com.example.gestionfacturation.ws;


import com.example.gestionfacturation.service.CurrencyService;
import com.example.gestionfacturation.bean.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestionFacturation/currency")
public class CurrencyWS {
    @GetMapping("/code/{code}")
    public Currency findByCode(@PathVariable String code) {
        return currencyService.findByCode(code);
    }
    @GetMapping("/mc/{mc}")
    public List<Currency> listOfCurrency(@PathVariable String mc) {
        return currencyService.listOfCurrency(mc);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return currencyService.deleteByCode(code);
    }

    @PostMapping("/")
    public int save(@RequestBody Currency currency) {
        return currencyService.save(currency);
    }
    @GetMapping("/nom/{nom}")
    public Currency findByNom(@PathVariable String nom) {
		return currencyService.findByNom(nom);
	}

	@Autowired
    private CurrencyService currencyService;

}
