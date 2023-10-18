package com.formationkilo.siacdas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formationkilo.siacdas.entities.Utilisateur;
import com.formationkilo.siacdas.service.UtilisateurService;

@Controller
public class UtilisateurController {

	
	private UtilisateurService utilisateurService;

	public UtilisateurController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}
	
	@RequestMapping(value="/inscription", method=RequestMethod.GET)
	public void inscription(Utilisateur utilisateur) {
        this.utilisateurService.inscription(utilisateur);
	}
	
}
