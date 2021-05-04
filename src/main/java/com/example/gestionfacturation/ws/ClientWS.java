package com.example.gestionfacturation.ws;

import com.example.gestionfacturation.service.ClientService;
import com.example.gestionfacturation.bean.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestionFacturation/client")
public class ClientWS {
    @GetMapping("/email/{email}")
    public Client findByEmail(@PathVariable String email) {
        return clientService.findByEmail(email);
    }
    @GetMapping("/mc/{mc}")
    public List<Client> listOfClients(@PathVariable String mc) {
        return clientService.listOfClients(mc);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByReference(@PathVariable String reference) {
        return clientService.deleteByReference(reference);
    }
@GetMapping("/reference/{reference}")
    public Client findByReference(@PathVariable String reference) {
		return clientService.findByReference(reference);
	}
	@PostMapping("/")
    public int save(@RequestBody Client client) {
        return clientService.save(client);
    }

    @Autowired
    private ClientService clientService;
}
