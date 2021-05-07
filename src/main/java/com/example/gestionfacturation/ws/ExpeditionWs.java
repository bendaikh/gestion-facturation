package com.example.gestionfacturation.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionfacturation.bean.Expedition;
import com.example.gestionfacturation.service.ExpeditionService;

@RestController
@RequestMapping("gestionFacturation/expedition")

public class ExpeditionWs {
	@Autowired
	private ExpeditionService expeditionService;
	@GetMapping("/code/{code}")
	public Expedition findByCode(@PathVariable String code) {
		return expeditionService.findByCode(code);
	}
@PostMapping("/")
	public int save(@RequestBody Expedition expedition) {
		return expeditionService.save(expedition);
	}
@GetMapping("/")
	public List<Expedition> findAll() {
		return expeditionService.findAll();
	}
	
}
