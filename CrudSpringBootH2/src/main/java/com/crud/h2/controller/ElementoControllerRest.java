package com.crud.h2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.h2.modelo.Elemento;
import com.crud.h2.modelo.Response;
import com.crud.h2.service.IElementoService;

@RestController
public class ElementoControllerRest {

	@Autowired
	private IElementoService service;
	
	@RequestMapping("/rest/listarElemento")
	public List<Elemento> listar(Model model) {		
		return service.listar();
	}
	
	@GetMapping("/rest/verCatalogo/{tipo}")
	public List<Elemento> listarCatalogo(@PathVariable String tipo, Model model) {
		return service.listarPorTipo(tipo);
	}
	
	@PostMapping("/agregarElemento")
	public Response agregar(@Valid Elemento p) {
		service.agregar(p);
		return new Response("OK", 300);
	}
		
	@PostMapping("/actualizarElemento")
	public Response actualizar(@Valid Elemento p) {
		service.editar(p);
		return new Response("OK", 300);
	}
	
	@GetMapping("/eliminarElemento/{id}")
	public Response delete(@PathVariable int id) {
		service.delete(id);
		return new Response("OK", 300);
	}
}
