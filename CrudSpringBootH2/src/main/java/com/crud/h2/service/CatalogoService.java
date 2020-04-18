package com.crud.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.h2.modelo.Catalogo;
import com.crud.h2.modeloDAO.ICatalogo;

@Service
public class CatalogoService implements ICatalogoService {

	@Autowired
	private ICatalogo dao;

	public List<Catalogo> listar() {
		return dao.listar();
	}

	public Catalogo listCatalogoId(int id) {
		return dao.listCatalogoId(id);
	}

	public int agregar(Catalogo p) {
		dao.agregar(p);
		return 0;
	}

	public int editar(Catalogo p) {
		dao.editar(p);
		return 0;
	}

	public void delete(int id) {
		dao.delete(id);

	}

}
