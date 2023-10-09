package com.formationkilo.siacdas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PagesController {

	@GetMapping("/")
	//@ResponseBody
	public String home(@RequestParam(required=false ,defaultValue="Inconnu(e)")  String name, ModelMap modelMap) {
		
		        modelMap.put("name", name);
		 return "pages/home";
			
		
	}
}
