package com.example.gestionfacturation.ws;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionfacturation.bean.FactureEtat;
import com.example.gestionfacturation.service.FactureEtatService;

@RestController
@RequestMapping(value="getionfacturation/facture_etat")
public class FactureEtatWs {
	@Autowired
	private FactureEtatService factureEtatService;
	@GetMapping("/reference/{reference}")
	public FactureEtat findByReference(@PathVariable String reference) {
	return factureEtatService.findByReference(reference);
	}
	@GetMapping("/")
	public List<FactureEtat> findAll() {
	return factureEtatService.findAll();
	}
	@PostMapping("/")
	public int save(@RequestBody FactureEtat factureEtat) {
	return factureEtatService.save(factureEtat);
	}

}
