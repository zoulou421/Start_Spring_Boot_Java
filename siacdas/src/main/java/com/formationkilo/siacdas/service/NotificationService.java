package com.formationkilo.siacdas.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.formationkilo.siacdas.entities.Validation;

@Service
public class NotificationService {

JavaMailSender javaMailSender;
	
	public void envoyer(Validation validation) {
		
		// Creating a simple mail message
        SimpleMailMessage mailMessage= new SimpleMailMessage();

        // Setting up necessary details
        String sender="no-reply@formationkilo.com";
        
        mailMessage.setFrom(sender);
        mailMessage.setTo(validation.getUtilisateur().getEmail());
        
        mailMessage.setSubject("Votre code de validation");
        
        String texte=String.format("Bonjour %s , votre code est: %s ", validation.getUtilisateur().getNom(), 
        		validation.getCode());
        
        mailMessage.setText(texte);
        
     // Sending the mail
        javaMailSender.send(mailMessage);
        

		
	}
}
