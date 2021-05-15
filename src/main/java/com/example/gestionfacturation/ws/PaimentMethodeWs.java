package com.example.gestionfacturation.ws;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionfacturation.bean.PaimentMethode;
import com.example.gestionfacturation.service.PaimentMethodeService;

@RestController
@RequestMapping(value="getionfacturation/paiment_methode")
public class PaimentMethodeWs {
	@Autowired
private PaimentMethodeService paimentMethodeService;
@GetMapping("/reference/{reference}")
public PaimentMethode findByReference(@PathVariable String reference) {
	return paimentMethodeService.findByReference(reference);
}
@GetMapping("/")
public List<PaimentMethode> findAll() {
	return paimentMethodeService.findAll();
}
@PostMapping("/")
public int save(@RequestBody PaimentMethode paimentMethode) {
	return paimentMethodeService.save(paimentMethode);
}
@GetMapping("/nom/{nom}")
public PaimentMethode findByNom(@PathVariable String nom) {
	return paimentMethodeService.findByNom(nom);
}

}
