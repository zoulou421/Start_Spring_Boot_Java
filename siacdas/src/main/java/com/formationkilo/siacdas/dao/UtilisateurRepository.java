package com.formationkilo.siacdas.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.formationkilo.siacdas.entities.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer>{

	//Optional <Utilisateur>findByUsername(String email);

	Optional<Utilisateur> findByEmail(String email);
	
}
