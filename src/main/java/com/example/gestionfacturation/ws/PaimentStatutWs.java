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
import com.example.gestionfacturation.bean.PaimentStatut;
import com.example.gestionfacturation.service.PaimentMethodeService;
import com.example.gestionfacturation.service.PaimentStatutService;

@RestController
@RequestMapping(value="getionfacturation/paiment_statut")
public class PaimentStatutWs {
	@Autowired
	private PaimentStatutService paimentStatutService;
	@GetMapping("/code/{code}")
	public PaimentStatut findByCode(@PathVariable String code) {
		return paimentStatutService.findByCode(code);
	}
	@GetMapping("/")
	public List<PaimentStatut> findAll() {
		return paimentStatutService.findAll();
	}
	@PostMapping("/")
	public int save(@RequestBody PaimentStatut paimentStatut) {
		return paimentStatutService.save(paimentStatut);
	}
	@GetMapping("/nom/{nom}")
	public PaimentStatut findByNom(@PathVariable String nom) {
		return paimentStatutService.findByNom(nom);
	}
}
