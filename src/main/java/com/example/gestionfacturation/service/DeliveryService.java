package com.example.gestionfacturation.service;

import com.example.gestionfacturation.dao.DeliveryDao;
import com.example.gestionfacturation.bean.Commande;
import com.example.gestionfacturation.bean.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {

    public int deleteByReference(String reference) {
        return deliveryDao.deleteByReference(reference);
    }

    public Delivery findByReference(String reference) {
        return deliveryDao.findByReference(reference);
    }

    public List<Delivery> listOfDeliveries(String mc) {
        return deliveryDao.listOfDeliveries(mc);
    }



    @Autowired
    private DeliveryDao deliveryDao;


        public void save(Commande commande, List<Delivery> deliveries) {
        for (Delivery delivery: deliveries) {
        	delivery.setCommande(commande);
            deliveryDao.save(delivery);

        }
    }
        
}
