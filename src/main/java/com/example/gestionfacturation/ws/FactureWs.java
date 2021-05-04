package com.example.gestionfacturation.ws;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionfacturation.bean.Facture;
import com.example.gestionfacturation.service.FactureService;

@RestController
@RequestMapping(value="getionfacturation/facture")
public class FactureWs {
	@Autowired
private FactureService factureService;
	@GetMapping("/reference/{reference}")
	public Facture findByReference(@PathVariable String reference) {
	return factureService.findByReference(reference);
	}
	@DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference) {
	return factureService.deleteByReference(reference);
	}
	@GetMapping("/search/{reference}")
public List<Facture> findByRef(@PathVariable String reference) {
		return factureService.findByRef(reference);
	}
@GetMapping("/nombrefacture/{reference}")
public Integer count(@PathVariable String reference) {
	return factureService.count(reference);
}
@GetMapping("/datecreation/{dateCreation}")
  public List<Facture> findByDateCreation(@PathVariable Date dateCreation) {
	return factureService.findByDateCreation(dateCreation);
}
@GetMapping("/")
public List<Facture> findAll() {
	return factureService.findAll();
 }
@PostMapping("/")
public int save(@RequestBody Facture facture) {
	return factureService.save(facture);
}
@PutMapping("/")
public void update(@RequestBody Facture facture) {
	factureService.update(facture);
}
	
}
