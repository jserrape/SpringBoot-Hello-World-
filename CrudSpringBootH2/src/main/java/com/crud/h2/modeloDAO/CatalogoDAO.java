package com.crud.h2.modeloDAO;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.crud.h2.modelo.Catalogo;

@Repository
public class CatalogoDAO implements ICatalogo {

	@Autowired
	private JdbcTemplate template;

	public List<Catalogo> listar() {
		String sql = "select * from catalogo";
		List<Catalogo> catalogos = template.query(sql, new BeanPropertyRowMapper<Catalogo>(Catalogo.class));
		return catalogos;
	}

	public Catalogo listCatalogoId(int id) {
		String sql="select * from catalogo where id=?";
		Catalogo per=template.queryForObject(sql,new Object[] {id},new BeanPropertyRowMapper<Catalogo>(Catalogo.class));
		return per;

	}
	
	public int agregar(Catalogo p) {
		String sql = "insert into catalogo(tipo)values(?)";
		int res = template.update(sql, p.getTipo());
		return res;
	}
	
	public void rellenarCatalogo(Catalogo p, MultipartFile file) {
		System.out.println("Voy a insertar el fichero en el catalogo: ".concat(p.getTipo()));
		try {
			String content = new String(file.getBytes(), StandardCharsets.UTF_8);
			String[] lines = content.split(System.getProperty("line.separator"));
			String sql = "insert into elemento(cadena,nombre_catalogo)values(?,?)";
			for(String line : lines) {
				template.update(sql, line, p.getTipo());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public int editar(Catalogo p) {
		String sql="update catalogo set tipo=? where id=?";
		int res=template.update(sql,p.getTipo(),p.getId());
		return res;
	}

	
	public void delete(int id) {
		String sql="delete from catalogo where id=?";
		template.update(sql,id);
	}

}
