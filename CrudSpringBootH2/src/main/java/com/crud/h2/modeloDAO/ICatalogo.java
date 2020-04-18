package com.crud.h2.modeloDAO;

import java.util.List;

import com.crud.h2.modelo.Catalogo;

public interface ICatalogo {
	public List<Catalogo> listar();

	public Catalogo listCatalogoId(int id);

	public int agregar(Catalogo p);

	public int editar(Catalogo p);

	public void delete(int id);
}
