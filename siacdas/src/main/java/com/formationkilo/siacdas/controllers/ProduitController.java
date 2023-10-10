package com.formationkilo.siacdas.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.formationkilo.siacdas.dao.ProduitRepository;
import com.formationkilo.siacdas.entities.Produit;

@Controller
public class ProduitController {

	@Autowired
	private ProduitRepository produitRepository;
	
	//@GetMapping("/")
	@RequestMapping(value="/index")
	public String index(Model model, 
			@RequestParam(name="page", defaultValue="0")int p ,
			@RequestParam(name="size", defaultValue="10")int s, 
			@RequestParam(name="motCle", defaultValue="") String mc) {
		
		//Page<Produit> pageProduits= produitRepository.findAll( PageRequest.of(p, s));
		Page<Produit> pageProduits= produitRepository.chercher("%"+mc+"%",PageRequest.of(p, s));
		model.addAttribute("list_produits",pageProduits.getContent());
		int [] pages= new int[pageProduits.getTotalPages()];
		model.addAttribute("pages",pages);
		model.addAttribute("size",s);
		model.addAttribute("pageCourante",p);
		model.addAttribute("motCle",mc);
		return "produits/list";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(Long id,String motCle, int page, int size)
	{
		 produitRepository.deleteById(id);
	     return "redirect:/index?page="+page+"&size="+size+"&motCle="+motCle;
		
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String ajouProduit(Model model) {
        model.addAttribute("produit", new Produit());
		return "produits/ajout";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Model model, @Valid Produit produit, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			
			System.out.println("################# Erreur récupérée ##########################"+bindingResult.hasErrors());
			return "produits/ajout";
		}
			produitRepository.save(produit);
			System.out.println("Aucune Erreur récupérée"+bindingResult.hasErrors());
			return "produits/confirmation";
		
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String edit(Model model, Long id) {
		
		Optional<Produit> p= produitRepository.findById(id);
        model.addAttribute("produit",p);
		return "produits/ajout";
	}
	
	
	@GetMapping("/")
	public String home() {
		 return "produits/layout";
				
	}
}
