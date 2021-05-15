package com.example.gestionfacturation.ws;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionfacturation.bean.FactureStatut;
import com.example.gestionfacturation.service.FactureStatutService;

@RestController
@RequestMapping(value="getionfacturation/facture_statut")
public class FactureStatutWs {
	@Autowired
	private FactureStatutService factureStatutService;
	@GetMapping("/reference/{reference}")
	public FactureStatut findByReference(@PathVariable String reference) {
		return factureStatutService.findByReference(reference);
	}
	@GetMapping("/")
	public List<FactureStatut> findAll() {
		return factureStatutService.findAll();
	}
	@PostMapping("/")
	public int save(@RequestBody FactureStatut factureStatut) {
		return factureStatutService.save(factureStatut);
	}
	@GetMapping("/nom/{nom}")
	public FactureStatut findByNom(@PathVariable String nom) {
		return factureStatutService.findByNom(nom);
	}
	
	
	
}
