package com.example.gestionfacturation.ws;

import com.example.gestionfacturation.service.CommandeService;
import com.example.gestionfacturation.bean.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestionFacturation/commande")
public class CommandeWS {
    @GetMapping("/reference/{reference}")
    public Commande findByReference(@PathVariable String reference) {
        return commandeService.findByReference(reference);
    }

    @GetMapping("/mc/{mc}")
    public List<Commande> listCommandes(@PathVariable String mc) {
        return commandeService.listCommandes(mc);
    }
    
    @GetMapping("/")
    public List<Commande> findAll() {
		return commandeService.findAll();
	}

	@DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return commandeService.deleteByReference(reference);
    }

    @PostMapping("/")
    public int save(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }

    @PutMapping("/")
    public void update(@RequestBody Commande commande) {
        commandeService.update(commande);
    }


    @Autowired

    private CommandeService commandeService;
}
