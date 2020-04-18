package com.crud.h2.modelo;

public class Elemento {
	private int id;
	private String nombre_catalogo;
	private String cadena;
	
	public Elemento() {
	}

	public Elemento(int id, String nombre_catalogo, String cadena) {
		super();
		this.id = id;
		this.nombre_catalogo = nombre_catalogo;
		this.cadena = cadena;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_catalogo() {
		return nombre_catalogo;
	}

	public void setNombre_catalogo(String nombre_catalogo) {
		this.nombre_catalogo = nombre_catalogo;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

}