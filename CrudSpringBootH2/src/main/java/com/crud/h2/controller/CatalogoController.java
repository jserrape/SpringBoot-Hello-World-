package com.crud.h2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.h2.service.ICatalogoService;

@Controller
public class CatalogoController {
	@Autowired
	private ICatalogoService service;

	@RequestMapping("/listarCatalogo")
	public String listar(Model model) {
		model.addAttribute("catalogos", service.listar());
		return "indexCatalogo";
	}


//	@GetMapping("/nuevoCatalogo")
//	public String nuevo() {
//		return "agregarCatalogo";
//	}

//	@GetMapping("/editarCatalogo/{id}")
//	public String editar(@PathVariable int id, Model model) {
//		Catalogo catalogo=service.listCatalogoId(id);
//		model.addAttribute("catalogo", catalogo);
//		return "editarCatalogo";
//	}

}
