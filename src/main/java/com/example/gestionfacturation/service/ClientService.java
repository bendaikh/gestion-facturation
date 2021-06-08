package com.example.gestionfacturation.service;

import com.example.gestionfacturation.dao.ClientDao;
import com.example.gestionfacturation.bean.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    public Client findByEmail(String email) {
        return clientDao.findByEmail(email);
    }

    public List<Client> listOfClients(String mc) {
        return clientDao.listOfClients(mc);
    }

    public int deleteByReference(String reference) {
        return clientDao.deleteByReference(reference);
    }

  

	public List<Client> findAll() {
		return clientDao.findAll();
	}

	public Client findByReference(String reference) {
		return clientDao.findByReference(reference);
	}

	public int save(Client client) {
        if (findByReference(client.getReference())!=null){
            return -1;
        }
        else {
            clientDao.save(client);
            return 1;
        }
    }

    @Autowired
    private ClientDao clientDao;




}
