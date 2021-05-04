package com.example.gestionfacturation.ws;

import com.example.gestionfacturation.service.DevisService;
import com.example.gestionfacturation.bean.Devis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gestionFacturation/devise")
public class DevisWS {
    @GetMapping("/reference/{reference}")
    public Devis findByReference(@PathVariable String reference) {
        return devisService.findByReference(reference);
    }
    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return devisService.deleteByReference(reference);
    }
    @PostMapping("/")
    public int save(@RequestBody Devis devis) {
        return devisService.save(devis);
    }

    @Autowired
    private DevisService devisService;
}
