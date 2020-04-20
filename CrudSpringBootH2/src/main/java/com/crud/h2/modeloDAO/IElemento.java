package com.crud.h2.modeloDAO;

import java.util.List;

import com.crud.h2.modelo.Elemento;

public interface IElemento {
	
	public List<Elemento> listar();
	
	public List<Elemento> listarPorTipo(String tipo);

	public Elemento listElementoId(int id);

	public int agregar(Elemento p);

	public int editar(Elemento p);

	public void delete(int id);
}