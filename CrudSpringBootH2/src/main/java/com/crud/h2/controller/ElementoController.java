package com.crud.h2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.h2.modelo.Elemento;
import com.crud.h2.service.ICatalogoService;
import com.crud.h2.service.IElementoService;

@Controller
//@RestController
public class ElementoController {
	@Autowired
	private IElementoService service;
	
	@Autowired
	private ICatalogoService serviceCatalogo;
	
	@GetMapping("/listarElemento")
	public String listar(Model model) {		
		model.addAttribute("elementos",service.listar());
		return "indexElemento";
		//return service.listar();
	}	
	
	@GetMapping("/nuevoElemento")
	public String nuevo(Model model) {
		model.addAttribute("catalogos",serviceCatalogo.listar());
		return "agregarElemento";
	}
	@PostMapping("/agregarElemento")
	public String agregar(@Valid Elemento p) {
		service.agregar(p);
		return "redirect:/listarElemento";
	}
	
	@GetMapping("/editarElemento/{id}")
	public String editar(@PathVariable int id, Model model) {
		Elemento elemento=service.listElementoId(id);
		model.addAttribute("elemento", elemento);
		model.addAttribute("catalogos",serviceCatalogo.listar());
		return "editarElemento";
	}
	
	@PostMapping("/actualizarElemento")
	public String actualizar(@Valid Elemento p) {
		service.editar(p);
		return "redirect:/listarElemento";
	}
	
	@GetMapping("/eliminarElemento/{id}")
	public String delete(@PathVariable int id) {
		service.delete(id);
		return "redirect:/listarElemento";
	}
	
	
	

}
