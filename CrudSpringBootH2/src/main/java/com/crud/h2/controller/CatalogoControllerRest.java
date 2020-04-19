package com.crud.h2.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crud.h2.modelo.Catalogo;
import com.crud.h2.service.ICatalogoService;

@RestController
public class CatalogoControllerRest {
	@Autowired
	private ICatalogoService service;
	
	@RequestMapping("/rest/listarCatalogo")
	public List<Catalogo> listar(Model model) {		
		return service.listar();
	}
	
	@PostMapping("/rest/agregarCatalogo")
	public String agregar(@Valid Catalogo p) {
		service.agregar(p);
		return "redirect:/listar";
	}
		
}