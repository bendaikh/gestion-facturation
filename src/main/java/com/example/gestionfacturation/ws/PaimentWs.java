package com.example.gestionfacturation.ws;
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
import com.example.gestionfacturation.bean.Paiment;
import com.example.gestionfacturation.service.PaimentService;

@RestController
@RequestMapping(value="getionfacturation/paiment")
public class PaimentWs {
	@Autowired
private PaimentService paimentService;
@GetMapping("/reference/{reference}")
public Paiment findByReference(@PathVariable String reference) {
	return paimentService.findByReference(reference);
}
@GetMapping("/paiment/facture/reference/{reference}")
public Facture findFactureByPaimentReference(@PathVariable String reference) {
	return paimentService.findFactureByPaimentReference(reference);
}

@GetMapping("/facture/reference/{reference}")
public List<Paiment> findByFactureReference(@PathVariable String reference) {
	return paimentService.findByFactureReference(reference);
}
@GetMapping("/")
public List<Paiment> findAll() {
	return paimentService.findAll();
}
@DeleteMapping("/facture/reference/{reference}")
public int deleteByFactureReference(@PathVariable String reference) {
	return paimentService.deleteByFactureReference(reference);
}
@DeleteMapping("/reference/{reference}")
public int deleteByReference(@PathVariable String reference) {
	return paimentService.deleteByReference(reference);
}
@GetMapping("/nombrepaiment/{reference}")
public Integer count(@PathVariable String reference) {
	return paimentService.count(reference);
}
@PostMapping("/")
public int save(@RequestBody Paiment paiment) {
	return paimentService.save(paiment);
}
@GetMapping("/montantfacture/{reference}")
public Double montantFacture(@PathVariable String reference) {
	return paimentService.montantFacture(reference);
}

@PutMapping("/")
public void update(@RequestBody Paiment paiment) {
	paimentService.update(paiment);
}

}
