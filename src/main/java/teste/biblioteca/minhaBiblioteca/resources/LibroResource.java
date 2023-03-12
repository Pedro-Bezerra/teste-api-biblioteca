package teste.biblioteca.minhaBiblioteca.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import teste.biblioteca.minhaBiblioteca.domain.Libro;

@RestController
@RequestMapping(value="/libros")
public class LibroResource {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Libro>> findAll() {
		Libro teste = new Libro("1", "A Second Harvest", "Eli Easton", "Romance", "Roco");
		List<Libro> list = new ArrayList<>();
		list.addAll(Arrays.asList(teste));
		return ResponseEntity.ok(list);
	}
}
