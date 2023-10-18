package com.formationkilo.siacdas.service;



import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.formationkilo.siacdas.dao.UtilisateurRepository;
import com.formationkilo.siacdas.entities.Role;
import com.formationkilo.siacdas.entities.Utilisateur;
import com.formationkilo.siacdas.enumeration.TypeDeRole;


@Service
public class UtilisateurService{

	private UtilisateurRepository utilisateurRepository;
	
	private BCryptPasswordEncoder passwordEncoder;
	
	private ValidationService validationService;
	
	public UtilisateurService( UtilisateurRepository utilisateurRepository,
			BCryptPasswordEncoder passwordEncoder, ValidationService validationService) {
		this.utilisateurRepository = utilisateurRepository;
		this.passwordEncoder=passwordEncoder;
		this.validationService=validationService;
	}

	public void inscription(Utilisateur utili) {
		String mdpCrypt=this.passwordEncoder.encode(utili.getMotDePasse());
		utili.setMotDePasse(mdpCrypt);
		if(!utili.getEmail().contains("@")) {
			throw new RuntimeException("Votre email est invalide");
		}
		
		if(!utili.getEmail().contains(".")) {
			throw new RuntimeException("Votre email est invalide");
		}
		
		Optional <Utilisateur>utilisateurOptional=this.utilisateurRepository.findByEmail(utili.getEmail()) ;
		
		if(utilisateurOptional.isPresent()) {
			throw new RuntimeException("Votre email est déjà utilisé");
		}
		Role role=new Role();
		role.setLibelle(TypeDeRole.UTILISATEUR);
		utili.setRole(role);
		utili=this.utilisateurRepository.save(utili);
		this.validationService.enregistrerUneValidation(utili);
		
	}
	
}
