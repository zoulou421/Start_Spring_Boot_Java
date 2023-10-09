package com.formationkilo.siacdas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PagesController {

	@GetMapping("/")
	//@ResponseBody
	public String home(HttpServletRequest request, ModelMap modelMap) {
		String param=request.getParameter("name");
		String name=param!=null && 
				!param.isEmpty()
				?param:"Renseignez votre nom pour voir.";
		        modelMap.put("name", name);
		 return "pages/home";
			
		
	}
}
