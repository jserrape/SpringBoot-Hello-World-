package com.crud.h2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.crud.h2.service.IElementoService;

@Controller
public class ElementoController {
	
	@Autowired
	private IElementoService service;
		
	@GetMapping("/listarElemento")
	public String listar(Model model) {		
		model.addAttribute("elementos",service.listar());
		return "indexElemento";
	}
	
	@GetMapping("/verCatalogo/{tipo}")
	public String listarCatalogo(@PathVariable String tipo, Model model) {
		model.addAttribute("elementos",service.listarPorTipo(tipo));
		return "indexElemento";
	}
	

//	@GetMapping("/nuevoElemento")
//	public String nuevo(Model model) {
//		model.addAttribute("catalogos",serviceCatalogo.listar());
//		return "agregarElemento";
//	}

//	@GetMapping("/editarElemento/{id}")
//	public String editar(@PathVariable int id, Model model) {
//		Elemento elemento=service.listElementoId(id);
//		model.addAttribute("elemento", elemento);
//		model.addAttribute("catalogos",serviceCatalogo.listar());
//		return "editarElemento";
//	}
	
}
