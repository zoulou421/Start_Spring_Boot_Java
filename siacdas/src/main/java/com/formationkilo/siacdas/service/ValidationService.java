package com.formationkilo.siacdas.service;

import java.time.Instant;
import java.time.temporal.Temporal;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.formationkilo.siacdas.dao.ValidationRepository;
import com.formationkilo.siacdas.entities.Utilisateur;
import com.formationkilo.siacdas.entities.Validation;

@Service
public class ValidationService {
	
	private ValidationRepository validationRepository;
	private NotificationService notificationService;

	public ValidationService(ValidationRepository validationRepository) {
		this.validationRepository = validationRepository;
	}
	
	public void enregistrerUneValidation(Utilisateur utilisateur) {
		Validation validation= new Validation();
		validation.setUtilisateur(utilisateur);
		Instant creation = Instant.now();
		Instant expiration = creation.plus(10, null);
		validation.setExpire(expiration);
		
		
		Random random= new Random();
	    int randomInteger =random.nextInt(999999);
	    String code =String.format("%06d", randomInteger);
	    validation.setCode(code);
	    
	    this.validationRepository.save(validation);
	
		
	}
	

}
