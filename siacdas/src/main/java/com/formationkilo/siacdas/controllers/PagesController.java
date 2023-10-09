package com.formationkilo.siacdas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PagesController {

	@GetMapping("/")
	@ResponseBody
	public String home() {
		return "<h1>Hello Word</h1>";
	}
}
