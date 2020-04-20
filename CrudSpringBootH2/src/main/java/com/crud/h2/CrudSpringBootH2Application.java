package com.crud.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CrudSpringBootH2Application implements CommandLineRunner  {
	
	@Autowired
	private JdbcTemplate template;
	
	public static void main(String[] args) {
		SpringApplication.run(CrudSpringBootH2Application.class, args);
	}

	public void run(String... args) throws Exception {
		//Catalogo
		template.execute("DROP TABLE CATALOGO IF EXISTS");
		template.execute("CREATE TABLE CATALOGO(id INTEGER(11) PRIMARY KEY auto_increment,tipo VARCHAR(255) NOT NULL UNIQUE)");
		
//		template.update("insert into catalogo(tipo)values('Direccion')");
//		template.update("insert into catalogo(tipo)values('Sexo')");
		
		//Elementos
		template.execute("DROP TABLE ELEMENTO IF EXISTS");
		template.execute("CREATE TABLE ELEMENTO(id INTEGER(11) PRIMARY KEY auto_increment, nombre_catalogo VARCHAR(255) NOT NULL, cadena VARCHAR(255))");
		
//		template.update("insert into elemento(nombre_catalogo,cadena)values('Direccion','Valencia')");
//		template.update("insert into elemento(nombre_catalogo,cadena)values('Direccion','Aragon')");
//		template.update("insert into elemento(nombre_catalogo,cadena)values('Direccion','Catalunya')");
//		template.update("insert into elemento(nombre_catalogo,cadena)values('Sexo','Hombre')");
//		template.update("insert into elemento(nombre_catalogo,cadena)values('Sexo','Mujer')");
	}

}
