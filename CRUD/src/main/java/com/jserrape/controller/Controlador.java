package com.jserrape.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jserrape.interfaceService.IPersonService;
import com.jserrape.model.Person;

@Controller
@RequestMapping
public class Controlador {

	@Autowired
	private IPersonService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Person> listPersons = service.listar();
		model.addAttribute("persons", listPersons);
		return "index";
	}
}
