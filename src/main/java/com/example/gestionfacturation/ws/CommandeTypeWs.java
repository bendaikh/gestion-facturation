package com.example.gestionfacturation.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionfacturation.bean.CommandeType;
import com.example.gestionfacturation.service.CommandeTypeService;

@RestController
@RequestMapping("gestionFacturation/commandetype")
public class CommandeTypeWs {
@Autowired
private CommandeTypeService commandeTypeService;
@GetMapping("/code/{code}")
public CommandeType findByCode(@PathVariable String code) {
	return commandeTypeService.findByCode(code);
}
@PostMapping("/")
public int save(@RequestBody CommandeType commandeType) {
	return commandeTypeService.save(commandeType);
}
@GetMapping("/")
public List<CommandeType> findAll() {
	return commandeTypeService.findAll();
}
@GetMapping("/nom/{nom}")
public CommandeType findByNom(@PathVariable String nom) {
	return commandeTypeService.findByNom(nom);
}


}
