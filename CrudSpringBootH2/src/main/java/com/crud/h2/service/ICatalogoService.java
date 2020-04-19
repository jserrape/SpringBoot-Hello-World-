package com.crud.h2.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.crud.h2.modelo.Catalogo;

public interface ICatalogoService {
	
	public List<Catalogo> listar();

	public Catalogo listCatalogoId(int id);

	public int agregar(Catalogo p);
	
	public void rellenarCatalogo(Catalogo p, MultipartFile file);

	public int editar(Catalogo p);

	public void delete(int id);
}
