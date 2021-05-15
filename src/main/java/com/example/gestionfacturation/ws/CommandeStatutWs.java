package com.example.gestionfacturation.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionfacturation.bean.CommandeStatut;
import com.example.gestionfacturation.service.CommandeStatutService;

@RestController
@RequestMapping("gestionFacturation/commandestatut")
public class CommandeStatutWs {
@Autowired
private CommandeStatutService commandeStatutService;
@GetMapping("/code/{code}")
public CommandeStatut findByCode(@PathVariable String code) {
	return commandeStatutService.findByCode(code);
}
@PostMapping("/")
public int save(@RequestBody CommandeStatut commandeStatut) {
	return commandeStatutService.save(commandeStatut);
}
@GetMapping("/nom/{nom}")
public CommandeStatut findByNom(@PathVariable String nom) {
	return commandeStatutService.findByNom(nom);
}
@GetMapping("/")
public List<CommandeStatut> findAll() {
	return commandeStatutService.findAll();
}

}
