package com.crud.h2.controller;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.validation.Valid;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.crud.h2.modelo.Catalogo;
import com.crud.h2.modelo.Response;
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
	public Response agregar(@Valid Catalogo p) {
		service.agregar(p);
		return new Response("OK", 300);
	}
		
	@PostMapping("/agregarMultiplesCatalogos")
	public Response agregarMultiples(@RequestParam("files") MultipartFile files[],
			@RequestParam("config") MultipartFile config) {
		System.out.println("Han llegado " + files.length + " ficheros de datos");
		System.out.println("Han llegado un fichero de configuracion llamado " + config.getOriginalFilename());

		try {
			String xmlString = new String(config.getBytes());

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xmlString));

			org.w3c.dom.Document doc = db.parse(is);
			NodeList nodes = doc.getElementsByTagName("file");

			// iterate the files
			for (int i = 0; i < nodes.getLength(); i++) {
				Element element = (Element) nodes.item(i);

				// here obtain the catalog name and create this on the ddbb
				NodeList name = element.getElementsByTagName("catalogname");
				Element line = (Element) name.item(0);
				Catalogo cat = new Catalogo(line.getFirstChild().getTextContent());
				service.agregar(cat);

				// find the file and create de elements
				NodeList title = element.getElementsByTagName("filename");
				line = (Element) title.item(0);
				String fileCatalog = line.getFirstChild().getTextContent();
				for (MultipartFile f : files) {
					if (f.getOriginalFilename().equals(fileCatalog)) {
						service.rellenarCatalogo(cat, f);
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return new Response("Internal error", 500);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response("Internal error", 500);
		}
		return new Response("OK", 300);
	}
	
	@PostMapping("/agregarCatalogo")
	public Response agregar(@RequestParam("file") MultipartFile file, @Valid Catalogo p) {
		service.agregar(p);
		// En caso de llegar un fichero lo cargo
		if (!file.getOriginalFilename().equals("")) {
			service.rellenarCatalogo(p, file);
		}
		return new Response("OK", 300);
	}

	@PostMapping("/actualizarCatalogo")
	public Response actualizar(@Valid Catalogo p) {
		service.editar(p);
		return new Response("OK", 300);
	}

	@GetMapping("/eliminarCatalogo/{id}")
	public Response delete(@PathVariable int id) {
		service.delete(id);
		return new Response("OK", 300);
	}
}