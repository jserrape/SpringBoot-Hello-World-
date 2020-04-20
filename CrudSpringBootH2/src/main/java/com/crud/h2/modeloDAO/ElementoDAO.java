package com.crud.h2.modeloDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crud.h2.modelo.Elemento;

@Repository
public class ElementoDAO implements IElemento {

	@Autowired
	private JdbcTemplate template;

	public List<Elemento> listar() {
		String sql = "select * from elemento";
		List<Elemento> elementos = template.query(sql, new BeanPropertyRowMapper<Elemento>(Elemento.class));
		return elementos;
	}
	
	public List<Elemento> listarPorTipo(String tipo) {
		String sql = "select * from elemento WHERE nombre_catalogo='" + tipo + "'";
		List<Elemento> elementos = template.query(sql, new BeanPropertyRowMapper<Elemento>(Elemento.class));
		return elementos;
	}
	
	public Elemento listElementoId(int id) {
		String sql="select * from elemento where id=?";
		Elemento per=template.queryForObject(sql,new Object[] {id},new BeanPropertyRowMapper<Elemento>(Elemento.class));
		return per;

	}

	
	public int agregar(Elemento p) {
		String sql = "insert into elemento(cadena,nombre_catalogo)values(?,?)";
		int res = template.update(sql, p.getCadena(), p.getNombre_catalogo());
		return res;
	}

	
	public int editar(Elemento p) {
		String sql="update elemento set cadena=? where id=?";
		int res=template.update(sql,p.getCadena(),p.getId());
		return res;
	}

	
	public void delete(int id) {
		String sql="delete from elemento where id=?";
		template.update(sql,id);
	}

}