package com.example.gestionfacturation.ws;

import com.example.gestionfacturation.service.QuotationStatusService;
import com.example.gestionfacturation.bean.QuotationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestionFacturation/quotationStatus")
public class QuotationStatusWS {
    @GetMapping("/mc/{mc}")
    public List<QuotationStatus> listOfQuotationStatus(@PathVariable String mc) {
        return quotationStatusService.listOfQuotationStatus(mc);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return quotationStatusService.deleteByCode(code);
    }
    @GetMapping("/code/{code}")
    public QuotationStatus findByCode(@PathVariable String code) {
        return quotationStatusService.findByCode(code);
    }
    @PostMapping("/")
    public int save(@RequestBody QuotationStatus quotationStatus) {
        return quotationStatusService.save(quotationStatus);
    }
    @GetMapping("/nom/{nom}")
    public QuotationStatus findByNom(@PathVariable String nom) {
		return quotationStatusService.findByNom(nom);
	}

	@Autowired
    private QuotationStatusService quotationStatusService;

}
