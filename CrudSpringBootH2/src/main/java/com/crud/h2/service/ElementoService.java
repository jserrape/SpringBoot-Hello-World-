package com.crud.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.h2.modelo.Catalogo;
import com.crud.h2.modelo.Elemento;
import com.crud.h2.modeloDAO.IElemento;

@Service
public class ElementoService implements IElementoService {

	@Autowired
	private IElemento dao;

	public List<Elemento> listar() {
		return dao.listar();
	}
	
	public List<Elemento> listarPorTipo(String tipo) {
		return dao.listarPorTipo(tipo);
	}

	public Elemento listElementoId(int id) {
		return dao.listElementoId(id);
	}

	public int agregar(Elemento p) {
		dao.agregar(p);
		return 0;
	}

	public int editar(Elemento p) {
		dao.editar(p);
		return 0;
	}

	public void delete(int id) {
		dao.delete(id);

	}

}