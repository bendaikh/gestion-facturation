package com.example.gestionfacturation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionfacturation.bean.CommandeType;
@Repository
public interface CommandeTypeDao extends JpaRepository<CommandeType,Long> {
	public  CommandeType findByCode(String code);
	public  CommandeType findByNom(String nom);

}
