package com.example.gestionfacturation.ws;


import com.example.gestionfacturation.service.DeliveryService;
import com.example.gestionfacturation.bean.Commande;
import com.example.gestionfacturation.bean.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestionFacturation/delivery")
public class DeliveryWS {
    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return deliveryService.deleteByReference(reference);
    }
    @GetMapping("reference/{reference}")
    public Delivery findByReference(@PathVariable String reference) {
        return deliveryService.findByReference(reference);
    }

    @GetMapping("/mc/{mc}")
    public List<Delivery> listOfDeliveries(@PathVariable String mc) {
        return deliveryService.listOfDeliveries(mc);
    }

    @PostMapping("/")
    public void save(@RequestBody Commande commande,@RequestBody List<Delivery> deliveries) {
        deliveryService.save(commande, deliveries);
    }




    @Autowired
    private DeliveryService deliveryService;
}
