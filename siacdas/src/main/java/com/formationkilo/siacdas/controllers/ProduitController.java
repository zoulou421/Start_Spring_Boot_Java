package com.formationkilo.siacdas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
}
