package teste.biblioteca.minhaBiblioteca.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import teste.biblioteca.minhaBiblioteca.domain.Libro;
import teste.biblioteca.minhaBiblioteca.services.LibroService;

@RestController
@RequestMapping(value="/libros")
public class LibroResource {
	
	@Autowired
	private LibroService service;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Libro>> findAll() {
		List<Libro> list = service.findAll();
		return ResponseEntity.ok(list);
	}
}
